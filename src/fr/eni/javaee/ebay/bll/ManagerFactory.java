package fr.eni.javaee.ebay.bll;

import fr.eni.javaee.ebay.bll.impl.ArticleManagerImpl;
import fr.eni.javaee.ebay.bll.impl.CategorieManagerImpl;
import fr.eni.javaee.ebay.bll.impl.UtilisateurManagerImpl;
import fr.eni.javaee.ebay.dal.DALException;

public class ManagerFactory {

	private static UtilisateurManager utilisateurManager;
	private static ArticleManager articleManager;
	private static CategorieManager categorieManager;

	public static UtilisateurManager getUtilisateurManageur() throws BLLException  {
		
		if(utilisateurManager == null) {
			try {
				utilisateurManager = new UtilisateurManagerImpl();
			} catch (DALException e) {
				
				e.printStackTrace();
				throw new BLLException(e.getMessage());
			}
		}		
		return utilisateurManager;
	}
	
	public static ArticleManager getArticleManager() throws BLLException {
		
		if(articleManager == null) {
			try {
				articleManager = new ArticleManagerImpl();
			} catch (DALException e) {
				
				e.printStackTrace();
				throw new BLLException(e.getMessage());
			}
		}
		return articleManager;
	}
	
	public static CategorieManager getCategorieManager() throws BLLException{
		
		if(categorieManager == null) {
			try {
				categorieManager = new CategorieManagerImpl();
			} catch (DALException e) {
				
				e.printStackTrace();
				throw new BLLException(e.getMessage());
			}
		}		
		return categorieManager;
	}

}
