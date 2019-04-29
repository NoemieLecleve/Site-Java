package fr.eni.javaee.ebay.bll.impl;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import fr.eni.javaee.ebay.bll.BLLException;
import fr.eni.javaee.ebay.bll.UtilisateurManager;
import fr.eni.javaee.ebay.bo.Utilisateur;
import fr.eni.javaee.ebay.dal.DALException;
import fr.eni.javaee.ebay.dal.DAOFactory;
import fr.eni.javaee.ebay.dal.UtilisateurDAO;

public class UtilisateurManagerImpl implements UtilisateurManager {

	private UtilisateurDAO utilisateurDAO;

	public UtilisateurManagerImpl() throws DALException {
		utilisateurDAO = DAOFactory.getUtilisateurDAO();
	}


	/**
	 * Ce manager demande à UtilisateurDAO de récupérer un utilisateur avec son pseudo et son mot de passe 
	 */
	@Override
	public Utilisateur seConnecter(Utilisateur utilisateur) throws BLLException {

		validationPseudo(utilisateur.getPseudo());
		validationMotDePasse(utilisateur.getMotDePasse());

		String motDePasse = utilisateur.getMotDePasse();
		String motDePasseCripter = cripterMDP(motDePasse);
		utilisateur.setMotDePasse(motDePasseCripter);

		try {
			return utilisateurDAO.seConnecter(utilisateur);
		} catch (DALException e) {
			
			throw new BLLException(e.getMessage());
		}
	}

	// Creer un utilisateur

	public Utilisateur creeUtilisateur(Utilisateur utilisateur, String confirmation) throws BLLException {
		
		boolean emailExiste;
		boolean pseudoExiste;
		
		// Validation des champs saisis
		validationEmail(utilisateur.getEmail());
		validationPseudo(utilisateur.getPseudo());
		confirmationMotDePasse(utilisateur.getMotDePasse(), confirmation);
		validationNom(utilisateur.getNom());
		validationNom(utilisateur.getPrenom());

		// Vérification de l'unicité pseudo et email en base 
		try {
			emailExiste = utilisateurDAO.verifierEmailExistant(utilisateur);
			pseudoExiste= utilisateurDAO.verifierPseudoExistant(utilisateur);
		} catch (DALException e1) {

			throw new BLLException(e1.getMessage());
		}
		
		// Gestion des erreurs d'unicité pseudo et email
		if(pseudoExiste) {
			throw new BLLException("Utilisateur existant");
		}
		else if(emailExiste) {
			throw new BLLException("Email existant");
		}
		// Sinon création de l'utilisateur
		else {
			String motDePasse = utilisateur.getMotDePasse();
			String motDePasseCripter = cripterMDP(motDePasse);
			utilisateur.setMotDePasse(motDePasseCripter);

			try {

				return utilisateurDAO.creerUtilisateur(utilisateur);

			} catch (DALException e) {

				throw new BLLException(e.getMessage());
			}			
		}
	}

	
	/**
	 * Ce manager permer de crypter le mot de passe de l'utilisateur avec le hash SHA256
	 * @param password
	 * @return
	 * @throws BLLException
	 */
	public String cripterMDP(String password) throws BLLException {

		MessageDigest md = null;

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


	// Valider l'adresse email saisie.

	public void validationEmail(String email) throws BLLException {

		// une expression régulière qui valide l'adresse e-mail
		if (email == null || !email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {

			throw new BLLException("Merci de saisir une adresse mail valide.");

		}

	}

	// Valide le mot de passe saisi.

	public void validationMotDePasse(String motDePasse) throws BLLException {

		if (motDePasse != null) {
			if (motDePasse.length() < 5) {

				throw new BLLException("Le mot de passe doit contenir au moins 5 caractères !!!");
			}
		} else if (motDePasse == null) {

			throw new BLLException("Merci de saisir votre mot de passe.");
		}
	}

	// Confirmation du mot de passe.

	public void confirmationMotDePasse(String motDePasse, String confirmation) throws BLLException {

		validationMotDePasse(motDePasse);

		if (confirmation != null) {
			if (!motDePasse.equals(confirmation)) {
				throw new BLLException("Les mots de passe entrés sont différents, merci de les saisir à nouveau.");
			}
		} else if (confirmation == null) {
			throw new BLLException("Merci de saisir et confirmer votre mot de passe.");
		}

	}

	// Valider le pseudo.

	public void validationPseudo(String pseudo) throws BLLException {

		// une expression régulière qui valide l'adresse e-mail
		if (pseudo != null) {
			if (pseudo.length() < 3) {

				throw new BLLException("Le pseudo doit contenir au moins 3 caractères !!!");
			}
		} else {

			throw new BLLException("Merci de saisir votre pseudo.");

		}
	}

	public void validationNom(String nom) throws BLLException {

		if (nom == null || nom.length() < 2) {
			throw new BLLException("Le nom d'utilisateur doit contenir au moins 2 caractères.");
		}
	}
	/**
	 * Ce manager demande à UtilisateurDAO de rechercher un utilisateur avec son identifiant
	 * @throws  BLLException
	 */
	@Override
	public Utilisateur recuperer(Utilisateur utilisateur) throws BLLException {
		
		Utilisateur utilisateurRecuperer = null;
		
		try {
			utilisateurRecuperer = utilisateurDAO.recuperer(utilisateur);
		} 
		catch (DALException  e) {
			throw new BLLException(e.getMessage());
		}
		if(utilisateurRecuperer == null) {
			throw new BLLException("Utilisateur inéxistant");
		}
		return utilisateurRecuperer;
	}

	/**
	 * Manager permettant de modifier un utilisateur en vérifiant les champs du formulaire 
	 */
	@Override
	public Utilisateur modifierUtilisateur(Utilisateur utilisateur, String nouveauPass, String confirmationPass) throws BLLException {
		
		boolean emailExiste;
		boolean pseudoExiste;
		boolean motDePasseExiste;
		
		// Validation des champs saisis
		validationEmail(utilisateur.getEmail());
		validationPseudo(utilisateur.getPseudo());
		validationNom(utilisateur.getNom());
		validationNom(utilisateur.getPrenom());		
		confirmationMotDePasse(nouveauPass, confirmationPass);
		
		// Cryptage du password
		String motDePasse = utilisateur.getMotDePasse();
		String motDePasseCripter = cripterMDP(motDePasse);
		utilisateur.setMotDePasse(motDePasseCripter);

		// Vérification de l'unicité pseudo et email en base
		// Vérification du mot de passe utilisateur
		try {
			emailExiste = utilisateurDAO.verifierEmailExistant(utilisateur);
			pseudoExiste = utilisateurDAO.verifierPseudoExistant(utilisateur);
			motDePasseExiste = utilisateurDAO.verifierMotDePasseExistant(utilisateur);
		} 
		catch (DALException e1) {

			throw new BLLException(e1.getMessage());
		}
		
		// Gestion des erreurs d'unicité pseudo et email
		if(pseudoExiste) {
			throw new BLLException("Utilisateur existant");
		}
		else if(emailExiste) {
			throw new BLLException("Email existant");
		}
		// Erreur de mot de passe
		else if(!motDePasseExiste) {
			throw new BLLException("Erreur mot de passe !");
		}
		// Sinon modification de l'utilisateur
		else {
			
			try {
				// Cryptage du password
				motDePasseCripter = cripterMDP(nouveauPass);
				utilisateur.setMotDePasse(motDePasseCripter);
				int nombreDeLigneModifier = utilisateurDAO.modifierUtilisateur(utilisateur);
				// Vérification du succès de la modification de l'utilisateur
				if(nombreDeLigneModifier == 1) {
					return utilisateur;
				}
				else {
					throw new BLLException("Utilisateur non modifié !");
				}				

			} catch (DALException e) {

				throw new BLLException(e.getMessage());
			}			
		}
	}

}
