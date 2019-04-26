package fr.eni.javaee.ebay.dal;

import fr.eni.javaee.ebay.dal.impl.ArticleDAOImpl;
import fr.eni.javaee.ebay.dal.impl.CategorieDAOImpl;
import fr.eni.javaee.ebay.dal.impl.UtilisateurDAOImpl;

public class DAOFactory {
	
	private static UtilisateurDAO utilisateurDAO;
	private static ArticleDAO articleDAO;
	private static CategorieDAO categorieDAO;

	public static UtilisateurDAO getUtilisateurDAO() throws DALException {
		
		if(utilisateurDAO == null) {
			utilisateurDAO = new UtilisateurDAOImpl();
		}
		return utilisateurDAO;
	}

	public static ArticleDAO getArticleDAO() throws DALException {
		
		if(articleDAO == null) {
			articleDAO = new ArticleDAOImpl();
		}
		return articleDAO;
	}

	public static CategorieDAO getCategorieDAO() throws DALException {
		
		if(categorieDAO == null) {
			categorieDAO = new CategorieDAOImpl();
		}
		return categorieDAO;
	}

}
