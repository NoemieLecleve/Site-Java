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
	private static final String INSERT_UTILISATEUR = "insert into UTILISATEURS " + "(pseudo,nom,prenom,email,telephone,"
			+ "rue,code_postal,ville,mot_de_passe)" + " values (?,?,?,?,?,?,?,?,?)";
	private static final String RECUPERE_UTILISATEUR = "SELECT * FROM UTILISATEURS WHERE no_utilisateur = ?;";
	

	public UtilisateurDAOImpl() throws DALException {
		connexion = ConnectionProvider.getInstance();
	}

	/**
	 * Cette DAO permet de récupérer un utilisateur avec son pseudo et son mot de passe
	 * @return un utilisateur
	 */
	@Override
	public Utilisateur seConnecter(Utilisateur utilisateur) throws DALException {

		Utilisateur utilisateurAuthentifier = null;

		try {
			PreparedStatement prepare = connexion.prepareStatement(CONNECTER_UTILISATEUR);
			prepare.setString(1, utilisateur.getPseudo());
			prepare.setString(2, utilisateur.getMotDePasse());
			ResultSet resultat = prepare.executeQuery();

			if (resultat.next()) {
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

				utilisateurAuthentifier = new Utilisateur(noUtilisateur, pseudo, nom, prenom, email, telephone, rue,
						codePostal, ville, motDePasse, credit, administrateur);

			}
		} catch (SQLException e) {
			throw new DALException("Echec requête se connecter !", e);
		}

		return utilisateurAuthentifier;
	}

	public Utilisateur creerUtilisateur(Utilisateur utilisateur) throws DALException {

		try {
			PreparedStatement prepare = connexion.prepareStatement(INSERT_UTILISATEUR,
					PreparedStatement.RETURN_GENERATED_KEYS);

			prepare.setString(1, utilisateur.getPseudo());
			prepare.setString(2, utilisateur.getNom());
			prepare.setString(3, utilisateur.getPrenom());
			prepare.setString(4, utilisateur.getEmail());
			prepare.setString(5, utilisateur.getTelephone());
			prepare.setString(6, utilisateur.getRue());
			prepare.setString(7, utilisateur.getCodePostal());
			prepare.setString(8, utilisateur.getVille());
			prepare.setString(9, utilisateur.getMotDePasse());

			prepare.executeUpdate();
			ResultSet resultat = prepare.getGeneratedKeys();

			if (resultat.next()) {

				utilisateur.setNoUtilisateur(resultat.getInt(1));
			}
		} catch (SQLException e) {

			throw new DALException("Echec requête creer utilisateur", e);
		}
		return utilisateur;

	}

	public boolean verifierPseudoExistant(Utilisateur utilisateur) throws DALException {

		int nbrePseudo;
		boolean pseudoExiste = false;

		try {

			// Requete permettant de vérifier si un pseudo est existant
			PreparedStatement prepare = connexion.prepareStatement(VERIFICATION_PSEUDO);
			prepare.setString(1, utilisateur.getPseudo());

			ResultSet resultat = prepare.executeQuery();

			if (resultat.next()) {

				nbrePseudo = resultat.getInt("num_pseudo");
				if (nbrePseudo != 0) {
					pseudoExiste = true;
				}
			}
		} 
		catch (SQLException e) {
			throw new DALException("Echec requête vérification pseudo", e);
		}
		return pseudoExiste;
	}

	public boolean verifierEmailExistant(Utilisateur utilisateur) throws DALException {

		int nbreEmail;
		boolean emailExiste = false;

		try {

			// Requete permettant de vérifier si un email est existant
			PreparedStatement prepare = connexion.prepareStatement(VERIFICATION_EMAIL);
			prepare.setString(1, utilisateur.getEmail());

			ResultSet resultat = prepare.executeQuery();

			if (resultat.next()) {

				nbreEmail = resultat.getInt("num_email");
				if (nbreEmail != 0) {
					emailExiste = true;
				}
			}
		} catch (SQLException e) {
			throw new DALException("Echec requête vérification email", e);
		}
		return emailExiste;
	}

	/**
	 * Cette DAO permet de récupérer un utilisateur à partir de son identifiant
	 */
	@Override
	public Utilisateur recuperer(Utilisateur utilisateur) throws DALException {
		
		Utilisateur utilisateurRecupere = null;
		
		try {
			PreparedStatement prepare = connexion.prepareStatement(RECUPERE_UTILISATEUR);			
			prepare.setInt(1, utilisateur.getNoUtilisateur());
			ResultSet resultat = prepare.executeQuery();
			
			if (resultat.next()) {
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

				utilisateurRecupere = new Utilisateur(noUtilisateur, pseudo, nom, prenom, email, telephone, rue,
						codePostal, ville, motDePasse, credit, administrateur);
			}
			
		}
		catch(SQLException e){
			throw new DALException("Echec requête récupérer un utilisateur ");
		}		
		return utilisateurRecupere;
	}

}
