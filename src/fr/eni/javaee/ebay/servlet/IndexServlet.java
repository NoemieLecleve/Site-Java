package fr.eni.javaee.ebay.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.javaee.ebay.bll.ArticleManager;
import fr.eni.javaee.ebay.bll.BLLException;
import fr.eni.javaee.ebay.bll.CategorieManager;
import fr.eni.javaee.ebay.bll.ManagerFactory;
import fr.eni.javaee.ebay.bll.RechercheManager;
import fr.eni.javaee.ebay.bo.ArticleVendu;
import fr.eni.javaee.ebay.bo.Categorie;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet({ "", "/home" })
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String PAGE_INDEX = "/WEB-INF/jsp/index.jsp";
	private static final String CHAMP_CATEGORIE = "noCategorie";
	private static final String CHAMP_RECHERCHE = "nomArticle";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IndexServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Cette méthode permet d'acceder à la page d'accueil du site Retourne une liste
	 * d'enchère et une liste de catégorie à la jsp
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArticleManager articleManager = null;
		CategorieManager categorieManager = null;

		try {
			articleManager = ManagerFactory.getArticleManager();
			categorieManager = ManagerFactory.getCategorieManager();

			List<ArticleVendu> listeArticles = articleManager.listerToutes();
			List<Categorie> listeCategories = categorieManager.listeCategories();

			request.setAttribute("listeArticles", listeArticles);
			request.setAttribute("listeCategories", listeCategories);
		} catch (BLLException e) {

			request.setAttribute("message", e.getMessage());
		}

		request.getRequestDispatcher(PAGE_INDEX).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int noCategorie = Integer.parseInt(request.getParameter(CHAMP_CATEGORIE));
		String nomArticle = request.getParameter(CHAMP_RECHERCHE);

		RechercheManager rechercheManager = null;

		try {
			rechercheManager = ManagerFactory.getRechercheManager();
			rechercheManager.articleRechercher(noCategorie, nomArticle);

			RequestDispatcher rd = request.getRequestDispatcher("home");
			rd.forward(request, response);

		} catch (BLLException e) {
			request.setAttribute("message", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/index.jsp");
			rd.forward(request, response);

		} 

		// doGet(request, response);

	}

}
