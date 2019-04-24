package fr.eni.javaee.ebay.bll.impl;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import fr.eni.javaee.ebay.bll.UtilisateurManager;
import fr.eni.javaee.ebay.bo.Utilisateur;
import fr.eni.javaee.ebay.dal.DAOFactory;
import fr.eni.javaee.ebay.dal.UtilisateurDAO;

public class UtilisateurManagerImpl implements UtilisateurManager {
	
	private UtilisateurDAO utilisateurDAO = DAOFactory.getUtilisateurDAO();

	@Override
	public Utilisateur seConnecter(Utilisateur utilisateur) {
		
		/*
		String motDePasse = utilisateur.getMotDePasse();
		String motDePasseCripter = cripterMDP(motDePasse);
		utilisateur.setMotDePasse(motDePasseCripter);
		*/		
		return utilisateurDAO.seConnecter(utilisateur);
	}
	
	private String cripterMDP(String password) {

        MessageDigest md = null;;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
		}
        byte[] hashInBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));

        StringBuilder sb = new StringBuilder();
        for (byte b : hashInBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
	}

}
