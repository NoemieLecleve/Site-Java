package fr.eni.javaee.ebay.bll.impl;

import fr.eni.javaee.ebay.bll.BLLException;
import fr.eni.javaee.ebay.bll.RechercheManager;
import fr.eni.javaee.ebay.bo.ArticleVendu;
import fr.eni.javaee.ebay.dal.DALException;
import fr.eni.javaee.ebay.dal.DAOFactory;
import fr.eni.javaee.ebay.dal.RechercheDAO;

/**
 * Implémentation de l'interface RechercheManager permettant de gérer les fonctionnalités du moteur de recherche
 * @author mleclerc2019
 *
 */
public class RechercheManagerImpl implements RechercheManager {
	
	RechercheDAO rechercheDAO = null;
	
	public RechercheManagerImpl() throws DALException {
		rechercheDAO = DAOFactory.getRechercheDAO();
	}

	/**
	 * 	Cette méthode demande à RechercheDAO de retourner un article à partir de sa catégorie et d'un nom d'article
	 */
	@Override
	public ArticleVendu articleRechercher(int numCategorie, String nomArticles) throws BLLException {
		
		
		try {
			return rechercheDAO.articleRechercher(numCategorie, nomArticles);
		} catch (DALException e) {
			
			e.printStackTrace();
			throw new BLLException(e.getMessage());
		}
	}

}
