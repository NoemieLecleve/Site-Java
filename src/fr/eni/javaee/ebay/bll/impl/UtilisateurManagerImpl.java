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

	
	//Connecter un utilisateur
	 
	@Override
	public Utilisateur seConnecter(Utilisateur utilisateur) throws BLLException {
		
		/*
		String motDePasse = utilisateur.getMotDePasse();
		String motDePasseCripter = cripterMDP(motDePasse);
		utilisateur.setMotDePasse(motDePasseCripter);
		*/
	
					
		    validationPseudo( utilisateur.getPseudo() );
	  
		 	validationMotDePasse( utilisateur.getMotDePasse() );
		 
		
		return utilisateurDAO.seConnecter(utilisateur);
		
	}
	
	// Cryptage du mot de passe 
	
	private String cripterMDP(String password) throws BLLException {

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

	 //Valider l'adresse email saisie.
   
    private void validationEmail( String email ) throws BLLException {
    	
    	//une expression régulière qui valide l'adresse e-mail
        if ( email != null && !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
          
				throw new BLLException( "Merci de saisir une adresse mail valide." );
			 
        }
    }
   private void validationPseudo( String pseudo ) throws BLLException {
    	
    	//une expression régulière qui valide l'adresse e-mail
	   if ( pseudo != null ) {
           if ( pseudo.length() < 3 ) {
                
					throw new BLLException( "Le pseudo doit contenir au moins 3 caractères !!!" ); 
           }
       } else {
            
				throw new BLLException( "Merci de saisir votre pseudo." );
			 
       }
    }
    
     //Valide le mot de passe saisi.
    
    private void validationMotDePasse (String motDePasse ) throws BLLException {
       
    	
    	if ( motDePasse != null ) {
            if ( motDePasse.length() < 5 ) {
                 
					throw new BLLException( "Le mot de passe doit contenir au moins 5 caractères !!!" ); 
            }
        } else {
             
				throw new BLLException( "Merci de saisir votre mot de passe." );
			 
        }
    }

  
 
	
	
	
	
}
