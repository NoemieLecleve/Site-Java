package fr.eni.javaee.ebay.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.javaee.ebay.bll.ArticleManager;
import fr.eni.javaee.ebay.bll.BLLException;
import fr.eni.javaee.ebay.bll.ManagerFactory;
import fr.eni.javaee.ebay.bll.UtilisateurManager;
import fr.eni.javaee.ebay.bo.ArticleVendu;
import fr.eni.javaee.ebay.bo.Utilisateur;

/**
 * Servlet implementation class DetailVente
 */
@WebServlet("/DetailVente")
public class DetailVente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DetailVente() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1:Récupération l'identifiant de l'utilisateur dans la session

		HttpSession session = request.getSession();

		int idUtilisateur = (int) session.getAttribute("sessionIdUtilisateur");

		// 2:Récupération de l'utilisateur via l'identifiant à la BLL -> DAO
		UtilisateurManager utilisateurManager = null;

		ArticleManager articleManager = null;

		try {
			utilisateurManager = ManagerFactory.getUtilisateurManageur();
			articleManager = ManagerFactory.getArticleManager();

			Utilisateur utilisateur = new Utilisateur();
			utilisateur.setNoUtilisateur(idUtilisateur);
			utilisateur = utilisateurManager.recuperer(utilisateur);

			ArticleManager articlemanager = ManagerFactory.getArticleManager();
			// On récupère l'article qui a été vendu
			ArticleVendu articleVendu = new ArticleVendu();
			// ArticleVendu article = articleManager.recupererArticleVendu(articleVendu);

			request.setAttribute("utilisateur", utilisateur);
		} catch (BLLException e) {
			request.setAttribute("message", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/detailVente.jsp");
			rd.forward(request, response);
			return;
		}

		// 3: Transmettre l'utilisateur à la JSP

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/detailVente.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
