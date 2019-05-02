package fr.eni.javaee.ebay.dal;

import fr.eni.javaee.ebay.bo.ArticleVendu;

public interface RechercheDAO {

	
	ArticleVendu articleRechercher(int numCategorie, String nomArticles) throws DALException;
}
