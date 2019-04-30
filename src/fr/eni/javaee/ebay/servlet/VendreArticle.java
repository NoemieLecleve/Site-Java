package fr.eni.javaee.ebay.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.javaee.ebay.bll.ArticleManager;
import fr.eni.javaee.ebay.bll.BLLException;
import fr.eni.javaee.ebay.bll.CategorieManager;
import fr.eni.javaee.ebay.bll.ManagerFactory;
import fr.eni.javaee.ebay.bll.UtilisateurManager;
import fr.eni.javaee.ebay.bo.ArticleVendu;
import fr.eni.javaee.ebay.bo.Categorie;
import fr.eni.javaee.ebay.bo.Retrait;
import fr.eni.javaee.ebay.bo.Utilisateur;
import fr.eni.javaee.ebay.dal.DALException;

/**
 * Servlet implementation class VendreArticle
 */
@WebServlet("/VendreArticle")
public class VendreArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 
     
    public VendreArticle() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	 
		CategorieManager categorieManager = null;

		try {
			 
			categorieManager = ManagerFactory.getCategorieManager();

			 
			List<Categorie> listeCategories = categorieManager.listeCategories();

			 
			request.setAttribute("listeCategories", listeCategories);
			
		} catch (DALException | BLLException e) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/vendreArticle.jsp");
			rd.forward(request, response);
			request.setAttribute("message", e.getMessage());
		}
		
	
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1:Récupération des paramétres de la requete
		
				String nomArticle = request.getParameter("nomArticle");
				String description = request.getParameter("description");
				String imagePath = request.getParameter("imagePath");
				String rueRetrait = request.getParameter("rueRetrait");
				String villeRetrait = request.getParameter("villeRetrait");
				String codePostalRetrait = request.getParameter("codePostalRetrait");
				
				int noCategorie = Integer.parseInt(request.getParameter("noCategorie"));
				int miseAPrix = Integer.parseInt(request.getParameter("miseAPrix"));
				   
			    Date dateDebutEncheres=new SimpleDateFormat("dd/MM/yyyy").parse("dateDebutEncheres");
			    
			    Date dateFinEncheres=new SimpleDateFormat("dd/MM/yyyy").parse("dateFinEncheres");
		
		// 2Récupération l'identifiant de l'utilisateur dans la session
		
				HttpSession session = request.getSession();
						
				int idUtilisateur=(int) session.getAttribute("sessionIdUtilisateur");
		
		// 3:Récupération de l'utilisateur via l'identifiant à la BLL -> DAO
				
			        UtilisateurManager utilisateurManager = null;
			        CategorieManager categorieManager = null;
			        ArticleManager  articleManager= null;
			        
			        utilisateurManager = ManagerFactory.getUtilisateurManageur();
					
			        categorieManager = ManagerFactory.getCategorieManager();
			        
			        articleManager = ManagerFactory.getArticleManager();
					 
				 //Creer un utilisateur,une categorie et un retrait:
				 					 
					Utilisateur utilisateur = new Utilisateur();
					utilisateur.setNoUtilisateur(idUtilisateur);
					utilisateur = utilisateurManager.recuperer(utilisateur);
					
					Categorie categorieArticle= new Categorie();
					categorieArticle = categorieManager.recupererCategorie(noCategorie);
					
					Retrait retrait= new Retrait (rueRetrait,villeRetrait,codePostalRetrait);
								      

	     // 4:Creer un article à partir des parametres de la JSP
	 
		   ArticleVendu articleVendu = new ArticleVendu(nomArticle, description, dateDebutEncheres,dateFinEncheres, 
	                                                    miseAPrix,categorieArticle, utilisateur,retrait,imagePath);
				
				 
				 
		   ArticleVendu  article  = articleManager.creerArticle(articleVendu);


		   request.setAttribute("article", article);
		   
		    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/vendreArticle.jsp");
			rd.forward(request, response);
		
	}	 
}
