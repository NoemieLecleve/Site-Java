package fr.eni.javaee.ebay.bll;

import fr.eni.javaee.ebay.bll.impl.ArticleManagerImpl;
import fr.eni.javaee.ebay.bll.impl.CategorieManagerImpl;
import fr.eni.javaee.ebay.bll.impl.UtilisateurManagerImpl;
import fr.eni.javaee.ebay.dal.DALException;

public class ManagerFactory {

	private static UtilisateurManager utilisateurManager;
	private static ArticleManager articleManager;
	private static CategorieManager categorieManager;

	public static UtilisateurManager getUtilisateurManageur() throws DALException  {
		
		if(utilisateurManager == null) {
			utilisateurManager = new UtilisateurManagerImpl();
		}		
		return utilisateurManager;
	}
	
	public static ArticleManager getArticleManager() throws DALException {
		
		if(articleManager == null) {
			articleManager = new ArticleManagerImpl();
		}
		return articleManager;
	}
	
	public static CategorieManager getCategorieManager() throws DALException{
		
		if(categorieManager == null) {
			categorieManager = new CategorieManagerImpl();
		}		
		return categorieManager;
	}

}
