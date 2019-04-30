package fr.eni.javaee.ebay.bll.impl;

import java.util.List;

import fr.eni.javaee.ebay.bll.BLLException;
import fr.eni.javaee.ebay.bll.CategorieManager;
import fr.eni.javaee.ebay.bo.Categorie;
import fr.eni.javaee.ebay.dal.CategorieDAO;
import fr.eni.javaee.ebay.dal.DALException;
import fr.eni.javaee.ebay.dal.DAOFactory;

public class CategorieManagerImpl implements CategorieManager {
	
	private CategorieDAO categorieDAO;
	
	public CategorieManagerImpl() throws DALException {
		categorieDAO = DAOFactory.getCategorieDAO();
	}

	@Override
	public List<Categorie> listeCategories() throws BLLException {
		
		try {
			return categorieDAO.listeCategories();
		} catch (DALException e) {
			
			throw new BLLException(e.getMessage());
		}
	}

	/**
	 * Cette méthode demande à CategorieDAO de récupérer une catégorie avec son identifiant
	 * @param no_categorie
	 * @throws BLLException
	 */
	@Override
	public Categorie recupererCategorie(int categorieId) throws BLLException {
		
		Categorie categorie = null;
		
		try {
			categorie = categorieDAO.recupererCategorie(categorieId);
		} 
		catch (DALException e) {
			e.printStackTrace();
			throw new BLLException(e.getMessage());
		}
		return categorie;
	}

}
