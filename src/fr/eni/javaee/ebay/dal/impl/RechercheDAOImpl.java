package fr.eni.javaee.ebay.dal.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.eni.javaee.ebay.bo.ArticleVendu;
import fr.eni.javaee.ebay.bo.Categorie;
import fr.eni.javaee.ebay.bo.Utilisateur;
import fr.eni.javaee.ebay.dal.ConnectionProvider;
import fr.eni.javaee.ebay.dal.DALException;
import fr.eni.javaee.ebay.dal.RechercheDAO;





public class RechercheDAOImpl implements RechercheDAO{
	
	private Connection connexion;

	private static final String SELECT_ARTICLE_BY_NUM_NOM = "SELECT * FROM ARTICLES_VENDUS A "
															+ "INNER JOIN CATEGORIES C ON A.NO_CATEGORIE = C.no_categorie "
															+ "WHERE a.no_categorie=5 and A.nom_article like '%?%';";

	
	
	
	public RechercheDAOImpl() throws DALException {
		
		connexion = ConnectionProvider.getInstance();		
		
	}
	
  public ArticleVendu articleRechercher(int numCategorie, String nomArticles) throws DALException {
		
	  ArticleVendu articleRechercher = null;
		try {
			
			PreparedStatement prepare = connexion.prepareStatement(SELECT_ARTICLE_BY_NUM_NOM);
			
			prepare.setInt(1, numCategorie);
			prepare.setString(2,nomArticles);
			
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
				
				Utilisateur utilisateur = new Utilisateur(pseudo, idUtilisateur);
				Categorie categorie= new Categorie (no_Categorie, libelle);
				
				articleRechercher = new ArticleVendu(nomArticle,description,prixInitial,dateFinEncheres,utilisateur,imagePath,categorie);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			throw new DALException("Echec requête récuperer une catégorie");
		}
		return articleRechercher;
	}
}
