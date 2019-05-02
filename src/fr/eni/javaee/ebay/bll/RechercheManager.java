package fr.eni.javaee.ebay.bll;

import fr.eni.javaee.ebay.bo.ArticleVendu;

public interface RechercheManager {
	
	ArticleVendu articleRechercher(int numCategorie, String nomArticles) throws BLLException;

}
