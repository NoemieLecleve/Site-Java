package fr.eni.javaee.ebay.bll;

import fr.eni.javaee.ebay.bll.impl.ArticleManagerImpl;
import fr.eni.javaee.ebay.bll.impl.CategorieManagerImpl;
import fr.eni.javaee.ebay.bll.impl.RechercheManagerImpl;
import fr.eni.javaee.ebay.bll.impl.UtilisateurManagerImpl;
import fr.eni.javaee.ebay.dal.DALException;

/**
 * Ce manager factory instancie les implémentations des interfaces manager
 * @author mleclerc2019
 *
 */
public class ManagerFactory {

	private static UtilisateurManager utilisateurManager;
	private static ArticleManager articleManager;
	private static CategorieManager categorieManager;
	private static RechercheManager rechercheManager;

	/** 
	 * @return Une instance UtilisateurManagerImpl
	 * @throws BLLException
	 */
	public static UtilisateurManager getUtilisateurManageur() throws BLLException  {
		
		if(utilisateurManager == null) {
			try {
				utilisateurManager = new UtilisateurManagerImpl();
			} catch (DALException e) {
				
				e.printStackTrace();
				throw new BLLException(e.getMessage());
			}
		}		
		return utilisateurManager;
	}
	
	/**
	 * 
	 * @return Une instance ArticleManagerImpl
	 * @throws BLLException
	 */
	public static ArticleManager getArticleManager() throws BLLException {
		
		if(articleManager == null) {
			try {
				articleManager = new ArticleManagerImpl();
			} catch (DALException e) {
				
				e.printStackTrace();
				throw new BLLException(e.getMessage());
			}
		}
		return articleManager;
	}
	/**
	 * 
	 * @return Une instance de CategorieManagerImpl
	 * @throws BLLException
	 */
	public static CategorieManager getCategorieManager() throws BLLException{
		
		if(categorieManager == null) {
			try {
				categorieManager = new CategorieManagerImpl();
			} catch (DALException e) {
				
				e.printStackTrace();
				throw new BLLException(e.getMessage());
			}
		}		
		return categorieManager;
	}
	
	/**
	 * 
	 * @return Une instance de RechercheManagerImpl
	 * @throws DALException
	 */
	public static RechercheManager getRechercheManager() throws BLLException {
		
		if(rechercheManager == null) {
			try {
				rechercheManager = new RechercheManagerImpl();
			} catch (DALException e) {
				
				e.printStackTrace();
				throw new BLLException(e.getMessage());
			}			
		}
		return rechercheManager;
	}

}
