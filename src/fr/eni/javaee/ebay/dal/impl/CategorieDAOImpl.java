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
	private static final String SELECT_CATEGORIES = "SELECT * FROM categories";

	public CategorieDAOImpl() throws DALException {
		connexion = ConnectionProvider.getInstance();
	}

	public List<Categorie> listeCategories() throws DALException {

		List<Categorie> categories = new ArrayList<Categorie>();

		try {
			PreparedStatement prepare = connexion.prepareStatement(SELECT_CATEGORIES);
			ResultSet resultat = prepare.executeQuery();

			while (resultat.next()) {
				String libelle = resultat.getString("libelle");

				Categorie categorie = new Categorie(libelle);

				categories.add(categorie);

			}

		} catch (SQLException e) {
			throw new DALException("Problème de récupération des catégories");

		}
		return categories;

	}

}
