package fr.eni.javaee.ebay.bll;

import fr.eni.javaee.ebay.bo.Utilisateur;

public interface UtilisateurManager {

	Utilisateur seConnecter(Utilisateur utilisateur) throws BLLException;
	void creeUtilisateur(Utilisateur utilisateur, String confirmation) throws BLLException;
}
