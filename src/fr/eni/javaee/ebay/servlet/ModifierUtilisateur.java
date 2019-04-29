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
 * Servlet implementation class ModifierUtilisateur
 */
@WebServlet("/ModifierUtilisateur")
public class ModifierUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CHAMP_PSEUDO = "pseudo";
	private static final String CHAMP_PRENOM = "prenom";
	private static final String CHAMP_NOM = "nom";
	private static final String CHAMP_TEL = "telephone";
	private static final String CHAMP_CODEPOSTAL = "codePostal";
	private static final String CHAMP_EMAIL = "email";
	private static final String CHAMP_RUE = "rue";
	private static final String CHAMP_VILLE = "ville";
	private static final String CHAMP_PASS = "password";
	private static final String CHAMP_NEWPASS = "nouveauMotPasse";
	private static final String CHAMP_PASSCONFIRM = "passwordConfirme";
	private static final int CREDIT = 0;
	private static final boolean ADMIN = false;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModifierUtilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		int idUtilisateur = (int) session.getAttribute("sessionIdUtilisateur");

		try {
			UtilisateurManager utilisateurManager = null;
			utilisateurManager = ManagerFactory.getUtilisateurManageur();

			Utilisateur utilisateur = new Utilisateur();
			utilisateur.setNoUtilisateur(idUtilisateur);

			utilisateur = utilisateurManager.recuperer(utilisateur);
			request.setAttribute("utilisateur", utilisateur);

			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/modifierProfil.jsp");
			rd.forward(request, response);

		} catch (BLLException e) {
			request.setAttribute("message", e.getMessage());
			response.sendRedirect("home");
			return;

		} catch (DALException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Récupération des paramétres de la requete
		String identifiant = request.getParameter(CHAMP_PSEUDO);
		String prenom = request.getParameter(CHAMP_PRENOM);
		String nom = request.getParameter(CHAMP_NOM);
		String telephone = request.getParameter(CHAMP_TEL);
		String codePostal = request.getParameter(CHAMP_CODEPOSTAL);
		String email = request.getParameter(CHAMP_EMAIL);
		String rue = request.getParameter(CHAMP_RUE);
		String ville = request.getParameter(CHAMP_VILLE);
		String motDePasse = request.getParameter(CHAMP_PASS);
		String nouveauMDP = request.getParameter(CHAMP_NEWPASS);
		String MDPconfirm = request.getParameter(CHAMP_PASSCONFIRM);

		// Creer un utilisateur à partir de la JSP
		Utilisateur utilisateur = new Utilisateur(identifiant, nom, prenom, email, telephone, rue, codePostal, ville,
				motDePasse, CREDIT, ADMIN);

		UtilisateurManager utilisateurManager = null;
		try {
			utilisateurManager = ManagerFactory.getUtilisateurManageur();

		} catch (DALException e) {
			request.setAttribute("message", e.getMessage());

		}

		try {
			utilisateurManager.modifierUtilisateur(utilisateur, MDPconfirm,	nouveauMDP);

			response.sendRedirect("RecupererUtilisateur");

		} 
		catch (BLLException e) {
			request.setAttribute("message", e.getMessage());
		}
		HttpSession session = request.getSession();

		int idUtilisateur = (int) session.getAttribute("sessionIdUtilisateur");

		try {

			Utilisateur utilisateurBdd = new Utilisateur();
			utilisateurBdd.setNoUtilisateur(idUtilisateur);

			utilisateurBdd = utilisateurManager.recuperer(utilisateurBdd);
			request.setAttribute("utilisateur", utilisateurBdd);

		} catch (BLLException e) {
			request.setAttribute("message", e.getMessage());
		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/modifierProfil.jsp");
		rd.forward(request, response);
	}

}
