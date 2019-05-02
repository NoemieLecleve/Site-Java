package fr.eni.javaee.ebay.bll;

import java.util.List;

import fr.eni.javaee.ebay.bo.ArticleVendu;

public interface RechercheManager {
	
	List<ArticleVendu> articleRechercher(int numCategorie, String nomArticles) throws BLLException;

}
