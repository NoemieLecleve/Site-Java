package fr.eni.javaee.ebay.dal;

import java.util.List;

import fr.eni.javaee.ebay.bo.Categorie;

public interface CategorieDAO {

	List<Categorie> listeCategories() throws DALException;
	Categorie recupererCategorie(int categorieId) throws DALException;
}
