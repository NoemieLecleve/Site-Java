package fr.eni.javaee.ebay.dal.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.eni.javaee.ebay.bo.ArticleVendu;
import fr.eni.javaee.ebay.bo.Utilisateur;
import fr.eni.javaee.ebay.dal.ArticleDAO;
import fr.eni.javaee.ebay.dal.ConnectionProvider;
import fr.eni.javaee.ebay.dal.DALException;

public class ArticleDAOImpl implements ArticleDAO {

	private Connection connexion;

	private static final String SELECT_ALL = "select nom_article, date_fin_encheres, a.imagePath as 'imagePath', u.no_utilisateur as no_utilisateur, "
			+ " prix_initial, pseudo from  ARTICLES_VENDUS a"
			+ " inner join  UTILISATEURS u on a.no_utilisateur = u.no_utilisateur;";
	private static final String INSERER_ARTICLE = "INSERT INTO ARTICLES_VENDUS "
			+ "(nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, imagePath, no_utilisateur, no_categorie) " 
			+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?);";
	private static final String AJOUTER_LIEU_RETRAIT = "INSERT INTO RETRAITS (no_article, rue, code_postal, ville) VALUES (?, ?, ?, ?);";
			

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
				String nomArticle = resultat.getString("nom_article");
				Date dateFinEncheres = resultat.getDate("date_fin_encheres");
				String imagePath = resultat.getString("imagePath");
				int idPseudo = resultat.getInt("no_utilisateur");
				int prixInitial = resultat.getInt("prix_initial");
				String pseudo = resultat.getString("pseudo");

				Utilisateur utilisateur = new Utilisateur(pseudo, idPseudo);

				ArticleVendu article = new ArticleVendu(nomArticle, dateFinEncheres, prixInitial, imagePath, utilisateur);

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
}
