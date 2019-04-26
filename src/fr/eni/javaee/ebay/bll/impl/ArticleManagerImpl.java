package fr.eni.javaee.ebay.bll.impl;

import java.util.List;

import fr.eni.javaee.ebay.bll.ArticleManager;
import fr.eni.javaee.ebay.bo.ArticleVendu;
import fr.eni.javaee.ebay.dal.ArticleDAO;
import fr.eni.javaee.ebay.dal.DALException;
import fr.eni.javaee.ebay.dal.DAOFactory;

public class ArticleManagerImpl implements ArticleManager {
	
	private ArticleDAO articleDAO = null;
	
	public ArticleManagerImpl() throws DALException {
		
		this.articleDAO = DAOFactory.getArticleDAO();
	}

	/**
	 * Liste toutes les encheres du site
	 * @throws DALException 
	 */
	@Override
	public List<ArticleVendu> listerToutes() throws DALException {
		
		return articleDAO.listerToutes();
	}

}
