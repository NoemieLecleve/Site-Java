package fr.eni.javaee.ebay.bll.impl;

import java.util.List;

import fr.eni.javaee.ebay.bll.ArticleManager;
import fr.eni.javaee.ebay.bo.ArticleVendu;
import fr.eni.javaee.ebay.bo.Enchere;
import fr.eni.javaee.ebay.dal.DAOFactory;

public class ArticleManagerImpl implements ArticleManager {
	
	private ArticleDAO articleDAO = null;
	
	public ArticleManagerImpl() {
		
		this.articleDAO = DAOFactory.getEnchereDAO();
	}

	/**
	 * Liste toutes les encheres du site
	 */
	@Override
	public List<ArticleVendu> listerToutes() {
		
		return articleDAO.listerToutes();
	}

}
