package fr.eni.javaee.ebay.bll;

import fr.eni.javaee.ebay.bll.impl.UtilisateurManagerImpl;
import fr.eni.javaee.ebay.dal.DALException;

public class ManagerFactory {
	
	public static UtilisateurManager getUtilisateurManageur() throws DALException {
		
		return new UtilisateurManagerImpl();
	}

}
