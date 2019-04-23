package fr.eni.javaee.ebay.dal;

import fr.eni.javaee.ebay.dal.impl.UtilisateurDAOImpl;

public class DAOFactory {
	
	public static UtilisateurDAO getUtilisateurDAO() {
		return new UtilisateurDAOImpl();
	}

}
