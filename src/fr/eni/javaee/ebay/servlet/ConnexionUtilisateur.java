package fr.eni.javaee.ebay.servlet;

import java.io.IOException;

import javax.net.ssl.ManagerFactoryParameters;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.javaee.ebay.bo.Utilisateur;
 

/**
 * Servlet implementation class ConnexionUtilisateur
 */
@WebServlet("/ConnexionUtilisateur")
public class ConnexionUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CHAMP_EMAIL  = "identifiant";
    private static final String CHAMP_PASS   = "motdepasse";   
    
   

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Affichage de la page d'inscription:
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/connexion.jsp").forward( request, response );
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String erreur ="Échec de la connexion.";
			String succes = "Succès de la connexion.";
     
		//1:Récupération des paramétres de la requete
		String identifiant = request.getParameter(CHAMP_EMAIL);
		String motDePasse = request.getParameter(CHAMP_PASS);
		
		//Creer un utilisateur à partir de la JSP
		Utilisateur utilisateurJSP= new Utilisateur (identifiant,motDePasse);
		
		UtilisateurManager utilisateurManager = ManagerFactory.getUtilisateurManager();
		
		
		Utilisateur utilisateur = utilisateurManager.seConnecter(utilisateurJSP);	
		
		//Récupération de la session depuis la requête 
      
		HttpSession session = request.getSession();
		
		//Si aucune erreur de validation n'a eu lieu, alors ajouter un
		//Utilisateur à la session, sinon suppression de la session.

		 if (utilisateur !=null) {
            session.setAttribute("sessionUtilisateur", utilisateur );
            request.setAttribute("message", succes );
            this.getServletContext().getRequestDispatcher("index.jsp").forward( request, response );
		 }
		 else {
         
			 this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/connexion.jsp").forward( request, response );
			 request.setAttribute("message", erreur );
		 }

		 request.setAttribute("utilisateur", utilisateur );
		
		
		doGet(request, response);
	}

}
