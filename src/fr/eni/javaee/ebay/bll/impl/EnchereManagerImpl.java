package fr.eni.javaee.ebay.bll.impl;

import java.util.List;

import fr.eni.javaee.ebay.bll.EnchereManager;
import fr.eni.javaee.ebay.bo.Enchere;

public class EnchereManagerImpl implements EnchereManager {
	
	private EnchereDAO enchereDAO = null;
	
	public EnchereManagerImpl() {
		
		this.enchereDAO = DAOFactory.getEnchereDAO();
	}

	/**
	 * Liste toutes les encheres du site
	 */
	@Override
	public List<Enchere> listerToutes() {
		
		return enchereDAO.listerToutes();
	}

}
