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
	private static final String SELECT_ALL = "select nom_article, date_fin_encheres, imagePath, u.no_utilisateur as no_utilisateur, "
			+ " prix_vente, pseudo from  ARTICLES_VENDUS a"
			+ " inner join  UTILISATEURS u on a.no_utilisateur = u.no_utilisateur;";

	public ArticleDAOImpl() throws DALException {
		connexion = ConnectionProvider.getInstance();
	}

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
				int prixVente = resultat.getInt("prix_vente");
				String pseudo = resultat.getString("pseudo");

				Utilisateur utilisateur = new Utilisateur(pseudo, idPseudo);

				ArticleVendu article = new ArticleVendu(nomArticle, dateFinEncheres, prixVente, imagePath, utilisateur );

				article.setUtilisateur(utilisateur);
				articles.add(article);
			}

		} catch (SQLException e) {
			throw new DALException("Problème de création de liste d'articles");

		}
		return articles;
	}
}
