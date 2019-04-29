package fr.eni.javaee.ebay.dal;

import fr.eni.javaee.ebay.bo.Utilisateur;

public interface UtilisateurDAO {
	
	Utilisateur seConnecter(Utilisateur utilisateur) throws DALException;
	Utilisateur recuperer(Utilisateur utilisateur) throws DALException;
	Utilisateur creerUtilisateur (Utilisateur utilisateur) throws DALException;
	int modifierUtilisateur(Utilisateur utilisateur) throws DALException; 
	boolean supprimerUtilisateur(Utilisateur utilisateur) throws DALException;
	boolean verifierPseudoExistant(Utilisateur utilisateur) throws DALException;
	boolean verifierEmailExistant(Utilisateur utilisateur) throws DALException;
	boolean verifierMotDePasseExistant(Utilisateur utilisateur)throws DALException;

}
