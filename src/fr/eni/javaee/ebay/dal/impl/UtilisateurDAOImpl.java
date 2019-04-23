package fr.eni.javaee.ebay.dal.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.javaee.ebay.bo.Utilisateur;
import fr.eni.javaee.ebay.dal.ConnectionProvider;
import fr.eni.javaee.ebay.dal.UtilisateurDAO;

public class UtilisateurDAOImpl implements UtilisateurDAO {
	
	private Connection connexion = ConnectionProvider.getInstance();
	private static final String CONNECTER_UTILISATEUR = "SELECT * FROM utilisateurs WHERE pseudo = ? AND mot_de_passe = HashBytes('SHA1',?);";
	

	@Override
	public Utilisateur seConnecter(Utilisateur utilisateur) {
		
		Utilisateur utilisateurAuthentifier = null;
		
		try {
			PreparedStatement prepare = connexion.prepareStatement(CONNECTER_UTILISATEUR);
			prepare.setString(1, utilisateur.getPseudo());
			prepare.setString(2, utilisateur.getMotDePasse());
			ResultSet resultat = prepare.executeQuery();
			
			if(resultat.next()) {
				int noUtilisateur = resultat.getInt("no_utilisateur");
				String pseudo = resultat.getString("pseudo");
				String nom = resultat.getString("nom");
				String prenom = resultat.getString("prenom");
				String email = resultat.getString("email");
				String telephone = resultat.getString("telephone");
				String rue = resultat.getString("rue");
				String codePostal = resultat.getString("code_postal");
				String ville = resultat.getString("ville");
				String motDePasse = resultat.getString("mot_de_passe");
				int credit = resultat.getInt("credit");
				boolean administrateur = resultat.getBoolean("administrateur");
				
				utilisateurAuthentifier = new Utilisateur(noUtilisateur,
															pseudo,
															nom,
															prenom,
															email,
															telephone,
															rue,
															codePostal,
															ville,
															motDePasse,
															credit,
															administrateur);
				return utilisateurAuthentifier;
			}			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return utilisateurAuthentifier;
	}
	
	

}
