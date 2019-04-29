package fr.eni.javaee.ebay.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.javaee.ebay.bll.BLLException;
import fr.eni.javaee.ebay.bll.ManagerFactory;
import fr.eni.javaee.ebay.bll.UtilisateurManager;
import fr.eni.javaee.ebay.bo.Utilisateur;
import fr.eni.javaee.ebay.dal.DALException;

/**
 * Servlet implementation class SupprimerUtilisateur
 */
@WebServlet("/SupprimerUtilisateur")
public class SupprimerUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SupprimerUtilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession(true);
		session.invalidate();
		response.sendRedirect("home");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 1:Récupération l'identifiant de l'utilisateur dans la session

		HttpSession session = request.getSession();
		int idUtilisateur = (int) session.getAttribute("sessionIdUtilisateur");

		UtilisateurManager utilisateurManager = null;

		try {
			utilisateurManager = ManagerFactory.getUtilisateurManageur();

		} catch (DALException e) {
			request.setAttribute("message", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/modifierProfil.jsp");
			rd.forward(request, response);
			return;

		}

		try {
			Utilisateur utilisateuraSupprimer = new Utilisateur();
			utilisateuraSupprimer.setNoUtilisateur(idUtilisateur);
			utilisateuraSupprimer = utilisateurManager.supprimerUtilisateur(utilisateuraSupprimer);
			request.setAttribute("utilisateur", utilisateuraSupprimer);

		} catch (BLLException e) {
			request.setAttribute("message", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/modifierProfil.jsp");
			rd.forward(request, response);
			return;
		}

	}

}
