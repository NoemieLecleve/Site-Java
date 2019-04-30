package fr.eni.javaee.ebay.bll;

import java.util.List;
import fr.eni.javaee.ebay.bo.Categorie;

public interface CategorieManager {
	
	List<Categorie> listeCategories() throws BLLException;
	Categorie recupererCategorie(int categorieId) throws BLLException;
}
