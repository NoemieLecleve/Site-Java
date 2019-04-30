package fr.eni.javaee.ebay.bll;

import java.util.List;

import fr.eni.javaee.ebay.bo.ArticleVendu;
import fr.eni.javaee.ebay.dal.DALException;

public interface ArticleManager {
	
	List<ArticleVendu> listerToutes() throws BLLException;
	ArticleVendu creerArticle(ArticleVendu article) throws BLLException;

}
