package fr.eni.javaee.ebay.dal.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.eni.javaee.ebay.bo.ArticleVendu;
import fr.eni.javaee.ebay.bo.Categorie;
import fr.eni.javaee.ebay.bo.Retrait;
import fr.eni.javaee.ebay.bo.Utilisateur;
import fr.eni.javaee.ebay.dal.ArticleDAO;
import fr.eni.javaee.ebay.dal.ConnectionProvider;
import fr.eni.javaee.ebay.dal.DALException;

public class ArticleDAOImpl implements ArticleDAO {

	private Connection connexion;

	private static final String SELECT_ALL = "select a.no_article, nom_article, date_fin_encheres, a.imagePath as 'imagePath', u.no_utilisateur as no_utilisateur, "
			+ " prix_initial, pseudo from  ARTICLES_VENDUS a"
			+ " inner join  UTILISATEURS u on a.no_utilisateur = u.no_utilisateur;";
	private static final String INSERER_ARTICLE = "INSERT INTO ARTICLES_VENDUS "
			+ "(nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, imagePath, no_utilisateur, no_categorie) " 
			+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?);";
	private static final String AJOUTER_LIEU_RETRAIT = "INSERT INTO RETRAITS (no_article, rue, code_postal, ville) VALUES (?, ?, ?, ?);";
			
	private static final String SELECT_ARTICLE_BY_ID = 		"SELECT * FROM ARTICLES_VENDUS a " 
														+	"INNER JOIN CATEGORIES c ON a.no_categorie = c.no_categorie "
														+ 	"INNER JOIN UTILISATEURS u ON u.no_utilisateur = a.no_utilisateur "
														+	"INNER JOIN RETRAITS r ON r.no_article = a.no_article "
														+	"WHERE a.no_article=?;";
	
	public ArticleDAOImpl() throws DALException {
		connexion = ConnectionProvider.getInstance();
	}

	/**
	 * Cette méthode liste tous les articles en ventes
	 * @throws DALException
	 */
	public List<ArticleVendu> listerToutes() throws DALException {

		List<ArticleVendu> articles = new ArrayList<ArticleVendu>();

		try {
			PreparedStatement prepare = connexion.prepareStatement(SELECT_ALL);
			ResultSet resultat = prepare.executeQuery();

			while (resultat.next()) {
				
				int numeroArticle = resultat.getInt("no_article");
				String nomArticle = resultat.getString("nom_article");
				Date dateFinEncheres = resultat.getDate("date_fin_encheres");
				String imagePath = resultat.getString("imagePath");
				int idPseudo = resultat.getInt("no_utilisateur");
				int prixInitial = resultat.getInt("prix_initial");
				String pseudo = resultat.getString("pseudo");

				Utilisateur utilisateur = new Utilisateur(pseudo, idPseudo);

				ArticleVendu article = new ArticleVendu(numeroArticle, nomArticle, dateFinEncheres, prixInitial, imagePath, utilisateur);

				article.setUtilisateur(utilisateur);
				articles.add(article);
			}

		} 
		catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Problème de création de liste d'articles");

		}
		return articles;
	}

	/**
	 * Cette méthode permet de créer un nouvel article en base de donnée
	 * @throws DALException
	 */
	@Override
	public boolean creerArticle(ArticleVendu article) throws DALException {
		
		try {
			PreparedStatement prepare = connexion.prepareStatement(INSERER_ARTICLE, PreparedStatement.RETURN_GENERATED_KEYS);
			
			java.sql.Date dateDebutSQL = new java.sql.Date(article.getDateDebutEncheres().getTime());
			java.sql.Date dateFinSQL = new java.sql.Date(article.getDateFinEncheres().getTime());

			prepare.setString(1, article.getNomArticle());
			prepare.setString(2, article.getDescription());
			prepare.setDate(3, dateDebutSQL);
			prepare.setDate(4, dateFinSQL);
			prepare.setInt(5, article.getMiseAPrix());
			prepare.setString(6,  article.getImagePath());
			prepare.setInt(7, article.getUtilisateur().getNoUtilisateur());
			prepare.setInt(8, article.getCategorieArticle().getNoCategorie());
			prepare.execute();
			
			ResultSet resultat = prepare.getGeneratedKeys();
			
			if(resultat.next()) {
				article.setNoArticle(resultat.getInt(1));
				//no_article,rue, code_postal, ville
				prepare = connexion.prepareStatement(AJOUTER_LIEU_RETRAIT);
				prepare.setInt(1, article.getNoArticle());
				prepare.setString(2, article.getRetrait().getRueRetrait());
				prepare.setString(3, article.getRetrait().getCodePostalRetrait());
				prepare.setString(4, article.getRetrait().getVilleRetrait());
				prepare.execute();
				return true;
			}
			else {
				return false;
			}			
		}
		catch(SQLException e) {
			e.printStackTrace();
			throw new DALException("Echec requête créer un article");
		}		
	}
    
	/**
	 * Cette méthode permet de rechercher un nouvel article en base de donnée avec son identifiant
	 * @throws DALException
	 */
	public ArticleVendu recupererArticle(int articleId) throws DALException {
		
		ArticleVendu article = null;
		try {
			PreparedStatement prepare = connexion.prepareStatement(SELECT_ARTICLE_BY_ID);
			prepare.setInt(1, articleId);
			ResultSet resultat = prepare.executeQuery();
			
			if(resultat.next()) {
				String nomArticle = resultat.getString("nom_article");
				String description = resultat.getString("description");
				int prixInitial = resultat.getInt("prix_initial");
				Date dateFinEncheres = resultat.getDate("date_fin_encheres");
				int idUtilisateur = resultat.getInt("no_utilisateur");
				String imagePath = resultat.getString("imagePath");
				String pseudo = resultat.getString("pseudo");
				int no_Categorie = resultat.getInt("no_categorie");
				String libelle = resultat.getString("libelle");
				String rue = resultat.getString("rue");
				String ville = resultat.getString("ville");
				String codePostale = resultat.getString("code_postal");
				
				Retrait retrait = new Retrait (rue,ville,codePostale );
				Utilisateur utilisateur = new Utilisateur(pseudo, idUtilisateur);
				Categorie categorie= new Categorie (no_Categorie, libelle);
				
				article  = new ArticleVendu(nomArticle,description,prixInitial,dateFinEncheres,utilisateur,imagePath,categorie,retrait);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			throw new DALException("Echec requête récuperer une catégorie");
		}
		return article;
	}

}

