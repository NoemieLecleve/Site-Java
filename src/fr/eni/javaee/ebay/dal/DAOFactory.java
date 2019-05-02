package fr.eni.javaee.ebay.dal;

import fr.eni.javaee.ebay.dal.impl.ArticleDAOImpl;
import fr.eni.javaee.ebay.dal.impl.CategorieDAOImpl;
import fr.eni.javaee.ebay.dal.impl.RechercheDAOImpl;
import fr.eni.javaee.ebay.dal.impl.UtilisateurDAOImpl;

/**
 * Cette factory instancie les implémentations des interfaces DAO
 * @author mleclerc2019
 *
 */
public class DAOFactory {
	
	private static UtilisateurDAO utilisateurDAO;
	private static ArticleDAO articleDAO;
	private static CategorieDAO categorieDAO;
	private static RechercheDAO rechercheDAO;

	/**
	 * 
	 * @return Une instance d' UtilisateurDAOImpl
	 * @throws DALException
	 */
	public static UtilisateurDAO getUtilisateurDAO() throws DALException {
		
		if(utilisateurDAO == null) {
			utilisateurDAO = new UtilisateurDAOImpl();
		}
		return utilisateurDAO;
	}

	/**
	 * 
	 * @return Une instance de ArticleDAOImpl
	 * @throws DALException
	 */
	public static ArticleDAO getArticleDAO() throws DALException {
		
		if(articleDAO == null) {
			articleDAO = new ArticleDAOImpl();
		}
		return articleDAO;
	}

	/**
	 * 
	 * @return Une instance de CategorieDAOImpl
	 * @throws DALException
	 */
	public static CategorieDAO getCategorieDAO() throws DALException {
		
		if(categorieDAO == null) {
			categorieDAO = new CategorieDAOImpl();
		}
		return categorieDAO;
	}
	
	/**
	 * 
	 * @return Une instance de RechercheDAOImpl
	 * @throws DALException
	 */
	public static RechercheDAO getRechercheDAO() throws DALException {
		
		if(rechercheDAO == null) {
			rechercheDAO = new RechercheDAOImpl();
		}
		return rechercheDAO;
	}

}
