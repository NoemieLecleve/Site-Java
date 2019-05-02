package fr.eni.javaee.ebay.dal;

import java.util.List;

import fr.eni.javaee.ebay.bo.ArticleVendu;

public interface ArticleDAO {

	List<ArticleVendu> listerToutes() throws DALException;
	boolean creerArticle(ArticleVendu article) throws DALException;
	ArticleVendu recupererArticle(int articleId) throws DALException;

}
