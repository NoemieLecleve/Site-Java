package fr.eni.javaee.ebay.dal.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.javaee.ebay.bo.Categorie;
import fr.eni.javaee.ebay.dal.CategorieDAO;
import fr.eni.javaee.ebay.dal.ConnectionProvider;
import fr.eni.javaee.ebay.dal.DALException;

public class CategorieDAOImpl implements CategorieDAO {

	private Connection connexion;
	private static final String SELECT_CATEGORIES = "SELECT * FROM CATEGORIES ORDER BY libelle";
	private static final String SELECT_CATEGORIE_BY_ID = "SELECT * FROM CATEGORIES WHERE no_categorie = ?;";

	public CategorieDAOImpl() throws DALException {
		connexion = ConnectionProvider.getInstance();
	}

	public List<Categorie> listeCategories() throws DALException {

		List<Categorie> categories = new ArrayList<Categorie>();

		try {
			PreparedStatement prepare = connexion.prepareStatement(SELECT_CATEGORIES);
			ResultSet resultat = prepare.executeQuery();

			while (resultat.next()) {
				int categorieId = resultat.getInt("no_categorie");
				String libelle = resultat.getString("libelle");

				Categorie categorie = new Categorie(categorieId, libelle);

				categories.add(categorie);

			}

		} catch (SQLException e) {
			throw new DALException("Problème de récupération des catégories");

		}
		return categories;

	}

	/**
	 * Cette méthode permet de récupérer une catégorie avec son identifiant
	 */
	@Override
	public Categorie recupererCategorie(int categorieId) throws DALException {
		
		Categorie categorie = null;
		try {
			PreparedStatement prepare = connexion.prepareStatement(SELECT_CATEGORIE_BY_ID);
			prepare.setInt(1, categorieId);
			ResultSet resultat = prepare.executeQuery();
			
			if(resultat.next()) {
				String libelle = resultat.getString("libelle");
				categorie = new Categorie(categorieId, libelle);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			throw new DALException("Echec requête récuperer une catégorie");
		}
		return categorie;
	}

}
