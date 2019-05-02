package fr.eni.javaee.ebay.bll.impl;

import java.util.Date;
import java.util.List;

import fr.eni.javaee.ebay.bll.ArticleManager;
import fr.eni.javaee.ebay.bll.BLLException;
import fr.eni.javaee.ebay.bo.ArticleVendu;
import fr.eni.javaee.ebay.bo.Categorie;
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
	 * @throws BLLException 
	 */
	@Override
	public List<ArticleVendu> listerToutes() throws BLLException  {
		
		try {
			return articleDAO.listerToutes();
		} 
		catch (DALException e) {
			throw new BLLException(e.getMessage());
		}
	}
	/**
	 * Cette méthode demande à ArticleDAO de récupérer un article avec son identifiant
	 * @param no_article
	 * @throws BLLException
	 */
	@Override
	public ArticleVendu recupererArticle(int articleId) throws BLLException {
		
		ArticleVendu article = null;
		
		try {
			article = articleDAO.recupererArticle(articleId);
		} 
		catch (DALException e) {
			e.printStackTrace();
			throw new BLLException(e.getMessage());
		}
		return article;
	}
	
	/**
	 * Cette méthode transmet un article 
	 * @throws BLLException
	 */
	@Override
	public ArticleVendu creerArticle(ArticleVendu article) throws BLLException{
		
		try {
			// Validation des champs de l'article
			validerNom(article.getNomArticle());
			validerDescription(article.getDescription());
			validerDateDebut(article.getDateDebutEncheres());
			validerDateFin(article.getDateFinEncheres());
			
			// Validation du retrait de l'article
			validerRue(article.getRetrait().getRueRetrait());
			validerCodePostal(article.getRetrait().getCodePostalRetrait());
			validerVille(article.getRetrait().getVilleRetrait());
			articleDAO.creerArticle(article);
			return article;
			
		} 
		catch (BLLException e) {					
			e.printStackTrace();
			throw new BLLException(e.getMessage());
		} 
		catch (DALException e) {				
			e.printStackTrace();
			throw new BLLException(e.getMessage());
		}		
	}
	
	public void validerNom(String champ) throws BLLException{		
		
		if(champ.isEmpty() || champ == null) {
			throw new BLLException ("Le nom est obligatoire");
		}		
	}
	public void validerDescription(String champ) throws BLLException{		
		
		if(champ.isEmpty() || champ == null) {
			throw new BLLException ("La description est obligatoire");
		}		
	}
	public void validerDateDebut(Date date) throws BLLException{		
		
		if(date == null) {
			throw new BLLException ("La date de début est obligatoire");
		}		
	}
	public void validerDateFin(Date date) throws BLLException{		
		
		if(date == null) {
			throw new BLLException ("La date de fin est obligatoire");
		}		
	}
	public void validerRue(String champ) throws BLLException{		
		
		if(champ.isEmpty() || champ == null) {
			throw new BLLException ("La rue est obligatoire");
		}		
	}
	public void validerCodePostal(String champ) throws BLLException{		
		
		if(champ.isEmpty() || champ == null) {
			throw new BLLException ("Le codepostal est obligatoire");
		}		
	}
	public void validerVille(String champ) throws BLLException{		
		
		if(champ.isEmpty() || champ == null) {
			throw new BLLException ("La ville est obligatoire");
		}		
	}
}
