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
 * Servlet implementation class RecupererUtilisateur
 */
@WebServlet("/RecupererUtilisateur")
public class RecupererUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecupererUtilisateur() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1:Récupération l'identifiant de l'utilisateur dans la session
				
		HttpSession session = request.getSession();
				
		int idUtilisateur=(int) session.getAttribute("sessionIdUtilisateur");
		
		
		// 2:Récupération de l'utilisateur via l'identifiant à la BLL -> DAO
		UtilisateurManager utilisateurManager = null;
		try {
			utilisateurManager = ManagerFactory.getUtilisateurManageur();
		} catch (DALException e) {
			request.setAttribute("message", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/profil.jsp");
			rd.forward(request, response);
			return;
		}
					
		try {
			 
			Utilisateur utilisateur = new Utilisateur();
			utilisateur.setNoUtilisateur(idUtilisateur);
			
			utilisateur = utilisateurManager.recuperer(utilisateur);
			request.setAttribute("utilisateur", utilisateur);
			
		} catch (BLLException e) {
			request.setAttribute("message", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/profil.jsp");
			rd.forward(request, response);
			return;
		}
		// 3: Transmettre l'utilisateur à la JSP
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/profil.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
				
				
	
	}

}
