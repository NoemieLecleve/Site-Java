package fr.eni.javaee.ebay.dal;

import fr.eni.javaee.ebay.dal.impl.ArticleDAOImpl;
import fr.eni.javaee.ebay.dal.impl.CategorieDAOImpl;
import fr.eni.javaee.ebay.dal.impl.UtilisateurDAOImpl;

public class DAOFactory {

	public static UtilisateurDAO getUtilisateurDAO() throws DALException {
		return new UtilisateurDAOImpl();
	}

	public static ArticleDAO getArticleDAO() throws DALException {
		// TODO Methode à revoir
		return new ArticleDAOImpl();
	}

	public static CategorieDAO getCategorieDAO() throws DALException {
		return new CategorieDAOImpl();
	}

}
