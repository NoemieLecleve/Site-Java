package fr.eni.javaee.ebay.servlet;

import java.io.IOException;
import java.text.ParseException;
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

/**
 * Servlet implementation class VendreArticle
 */
@WebServlet("/VendreArticle")
public class VendreArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public VendreArticle() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CategorieManager categorieManager = null;

		try {

			categorieManager = ManagerFactory.getCategorieManager();

			List<Categorie> listeCategories = categorieManager.listeCategories();

			request.setAttribute("listeCategories", listeCategories);
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/vendreArticle.jsp");
			rd.forward(request, response);

		} catch (BLLException e) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/vendreArticle.jsp");
			rd.forward(request, response);
			request.setAttribute("message", e.getMessage());
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1:Récupération des paramétres de la requete

		String nomArticle = request.getParameter("nomArticle");
		String description = request.getParameter("description");
		String imagePath = request.getParameter("imagePath");
		String rueRetrait = request.getParameter("rueRetrait");
		String dateDebutEncheresJSP=request.getParameter("dateDebutEncheres");
		String dateFinEncheresJSP=request.getParameter("dateFinEncheres");
		String villeRetrait = request.getParameter("villeRetrait");
		String codePostalRetrait = request.getParameter("codePostalRetrait");

		int noCategorie = Integer.parseInt(request.getParameter("noCategorie"));
		System.out.println("*******************" + request.getParameter("miseAPrix"));
		int miseAPrix = Integer.parseInt(request.getParameter("miseAPrix"));

		Date dateDebutEncheres = null;
		Date dateFinEncheres = null;
		try {
			dateDebutEncheres = new SimpleDateFormat("yyyy-MM-dd").parse(dateDebutEncheresJSP);
			dateFinEncheres = new SimpleDateFormat("yyyy-MM-dd").parse(dateFinEncheresJSP);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		// 2Récupération l'identifiant de l'utilisateur dans la session

		HttpSession session = request.getSession();

		int idUtilisateur = (int) session.getAttribute("sessionIdUtilisateur");

		// 3:Récupération de l'utilisateur via l'identifiant à la BLL -> DAO

		UtilisateurManager utilisateurManager = null;
		CategorieManager categorieManager = null;
		ArticleManager articleManager = null;

		try {
			utilisateurManager = ManagerFactory.getUtilisateurManageur();
			categorieManager = ManagerFactory.getCategorieManager();
			articleManager = ManagerFactory.getArticleManager();

			// Creer un utilisateur,une categorie et un retrait:

			Utilisateur utilisateur = new Utilisateur();
			utilisateur.setNoUtilisateur(idUtilisateur);
			Categorie categorieArticle = new Categorie();
			Retrait retrait = new Retrait(rueRetrait, villeRetrait, codePostalRetrait);

			utilisateur = utilisateurManager.recuperer(utilisateur);
			categorieArticle = categorieManager.recupererCategorie(noCategorie);

			// 4:Creer un article à partir des parametres de la JSP

			ArticleVendu articleVendu = new ArticleVendu(nomArticle, description, dateDebutEncheres, dateFinEncheres,
					miseAPrix, categorieArticle, utilisateur, retrait, imagePath);

			ArticleVendu article = articleManager.creerArticle(articleVendu);
			request.setAttribute("article", article);
			// TODO détail de la vente
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/detailVente.jsp");
			rd.forward(request, response);
		} catch (BLLException e) {

			request.setAttribute("message", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/vendreArticle.jsp");
			rd.forward(request, response);

		}

	}
}
