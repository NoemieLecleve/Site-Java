package fr.eni.javaee.ebay.bll;

import fr.eni.javaee.ebay.bll.impl.UtilisateurManagerImpl;

public class ManagerFactory {
	
	public static UtilisateurManager getUtilisateurManageur() {
		
		return new UtilisateurManagerImpl();
	}

}
