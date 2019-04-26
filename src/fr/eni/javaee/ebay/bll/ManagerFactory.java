package fr.eni.javaee.ebay.bll;

import fr.eni.javaee.ebay.bll.impl.ArticleManagerImpl;
import fr.eni.javaee.ebay.bll.impl.UtilisateurManagerImpl;
import fr.eni.javaee.ebay.dal.DALException;

public class ManagerFactory {
	
	/**
	 * 
	 * @return Une instance UtilisateurManagerImpl
	 * @throws DALException
	 */
	public static UtilisateurManager getUtilisateurManageur() throws DALException {
		
		return new UtilisateurManagerImpl();
	}
	
	public static ArticleManager getEnchereManager() {
		
		return new ArticleManagerImpl();
	}

}
