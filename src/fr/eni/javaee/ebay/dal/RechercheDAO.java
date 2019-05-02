package fr.eni.javaee.ebay.dal;

import java.util.List;

import fr.eni.javaee.ebay.bo.ArticleVendu;

public interface RechercheDAO {

	
	List<ArticleVendu> articleRechercher(int numCategorie, String nomArticles) throws DALException;
}
