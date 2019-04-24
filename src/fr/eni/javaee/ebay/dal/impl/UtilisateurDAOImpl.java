package fr.eni.javaee.ebay.dal.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.javaee.ebay.bo.Utilisateur;
import fr.eni.javaee.ebay.dal.ConnectionProvider;
import fr.eni.javaee.ebay.dal.DALException;
import fr.eni.javaee.ebay.dal.UtilisateurDAO;

public class UtilisateurDAOImpl implements UtilisateurDAO {
	
	private Connection connexion;
	private static final String VERIFICATION_EMAIL = "SELECT count(no_utilisateur) as 'num_email' "
														+ "FROM UTILISATEURS WHERE email =? ";
	private static final String VERIFICATION_PSEUDO = "SELECT count(no_utilisateur) as 'num_pseudo' "
														+ "FROM UTILISATEURS WHERE pseudo=?";
	private static final String CONNECTER_UTILISATEUR = "SELECT * FROM utilisateurs WHERE pseudo = ? AND mot_de_passe = ?;";
	private static final String INSERT_UTILISATEUR = "insert into UTILISATEURS "
														+ "(pseudo,nom,prenom,email,telephone,"
														+ "rue,code_postal,ville,mot_de_passe)"
														+ " values (?,?,?,?,?,?,?,?,?)";
	
	
	public UtilisateurDAOImpl() throws DALException {
		connexion = ConnectionProvider.getInstance();
	}
	

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
	
	
	public Utilisateur creerUtilisateur (Utilisateur utilisateur) throws DALException {
		
		 
		
		try {
			PreparedStatement prepare = connexion.prepareStatement(INSERT_UTILISATEUR,PreparedStatement.RETURN_GENERATED_KEYS);
			
			prepare.setString(1, utilisateur.getPseudo());
			prepare.setString(2, utilisateur.getNom());
			prepare.setString(3, utilisateur.getPrenom());
			prepare.setString(4, utilisateur.getEmail());
			prepare.setString(5, utilisateur.getTelephone());
			prepare.setString(6, utilisateur.getRue());
			prepare.setString(7, utilisateur.getCodePostal());
			prepare.setString(8, utilisateur.getVille());
			prepare.setString(9, utilisateur.getMotDePasse());
					
			
		    prepare.execute();
			ResultSet resultat = prepare.getGeneratedKeys();
			 
			 
			if(resultat.next()) {
				
				utilisateur.setNoUtilisateur(resultat.getInt(1));
			}			
		}catch(SQLException e) {
						
			throw new DALException("Problème pour interroger la base de donnes", e);
		}
		return utilisateur;
	
	}

    
	public void verifierUtilisateur(Utilisateur utilisateur) throws DALException {
				 
		
		try {
			PreparedStatement prepare = connexion.prepareStatement(VERIFICATION_EMAIL);
			prepare.setInt(1, utilisateur.getNoUtilisateur());
		 			
			ResultSet resultat = prepare.executeQuery();
			
			 			
			if (resultat.next()) {
				
				int no_email = resultat.getInt("num_email");
				
				 
				if( no_email==0) {
					
					PreparedStatement prepare1 = connexion.prepareStatement(INSERT_UTILISATEUR,PreparedStatement.RETURN_GENERATED_KEYS);
					
					prepare1.setString(1, utilisateur.getPseudo());
					prepare1.setString(2, utilisateur.getNom());
					prepare1.setString(3, utilisateur.getPrenom());
					prepare1.setString(4, utilisateur.getEmail());
					prepare1.setString(5, utilisateur.getTelephone());
					prepare1.setString(6, utilisateur.getRue());
					prepare1.setString(7, utilisateur.getCodePostal());
					prepare1.setString(8, utilisateur.getVille());
					prepare1.setString(9, utilisateur.getMotDePasse());
							
					
				    prepare1.execute();
					ResultSet resultat1 = prepare1.getGeneratedKeys();
					 
					 
					if(resultat1.next()) {
						
						utilisateur.setNoUtilisateur(resultat1.getInt(1));
					}			
				}
				 
				else {
					throw new DALException ("Utilisateur existe deja!!!");
				}
			}			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
