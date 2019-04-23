package fr.eni.javaee.ebay.bll.impl;

import fr.eni.javaee.ebay.bll.UtilisateurManager;
import fr.eni.javaee.ebay.bo.Utilisateur;
import fr.eni.javaee.ebay.dal.DAOFactory;
import fr.eni.javaee.ebay.dal.UtilisateurDAO;

public class UtilisateurManagerImpl implements UtilisateurManager {
	
	private UtilisateurDAO utilisateurDAO = DAOFactory.getUtilisateurDAO();

	@Override
	public Utilisateur seConnecter(Utilisateur utilisateur) {
		
		return utilisateurDAO.seConnecter(utilisateur);
	}

}
