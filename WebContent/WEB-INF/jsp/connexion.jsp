<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://fonts.googleapis.com/css?family=Oxygen" rel="stylesheet">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
<link href="css/style.css" rel="stylesheet">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
 <title>Se Connecter</title>
    
    
 <header>
        <%@ include file="header.jsp" %>
</header>

<main class="connexion"> 		  			
		<form method="post" action="ConnexionUtilisateur" class="container">
		  <fieldset>
		  	<div class="blue">
		  		<legend>Connexion</legend>
		  	</div>
			   <div class="background">
			    <div class="main-padding login-wrapper">
	             <div class="split-50 border">
                  <div class="split-wrap">
                  <strong class="text-center ">Connectez-vous</strong>
	            	<form class="px-4 py-3">
		                <div class="form-group">
		                    <label for="exampleDropdownFormEmail1"> Pseudo :</label>
		                    <input type="text" class="form-control" name="identifiant" placeholder="Pseudo">
		                </div>
		                <div class="form-group">
		                    <label for="exampleDropdownFormPassword1">Mot de passe :</label>
		                    <input type="password" class="form-control" name="motdepasse" placeholder="mot de passe">
		                </div>
		                <div class="form-check">
		                    <input type="checkbox" class="form-check-input" id="dropdownCheck">
		                    <label class="form-check-label" for="dropdownCheck">Rester connecté</label>
		                </div>
		                <br>
		                <button type="submit" class="btn btn-warning active">S'identifier</button>
	            	</form>
	            <div class="dropdown-divider"></div>
	            <a class="dropdown-item text-muted" href="InscriptionUtilisateur">Pas encore de compte ? Inscrivez-vous gratuitement</a>
	            <a class="dropdown-item text-muted" href="#">Mot de passe oublié ?</a>
	       		 </div>
	       	  </div>
	        </div>	
       		  <p class="erreur"> ${message}</p>	

	  		  <!--   Vérification de la présence d'un objet utilisateur en session -->
                <c:if test="${!empty sessionScope.sessionUtilisateur}">
                    <!-- Si l'utilisateur existe en session, alors on affiche son pseudo. -->
                    <p>${sessionScope.sessionUtilisateur.pseudo}</p>             
                </c:if> 
             </div>
  		   </fieldset>
  		  </form>	
</main>
<footer>
	<nav>
		<a href="home">Acceuil</a><a href="#">FAQ</a><a href="#">Contact</a><a href="ConnexionUtilisateur">Se connecter</a> 
	</nav>
	<div>
	  <strong>Suivez nous sur les réseaux sociaux !</strong>
		<p> Avec ENI-encheres, achetez aux enchères, en salle ou sur Internet. 281 commissaires-priseurs garantissent les objets.
		 Ces derniers publient quotidiennement en ligne les informations relatives à leurs prochaines ventes aux enchères sur le site. 
		 Ils permettent ainsi aux acheteurs du monde entier de consulter gratuitement la quasi-totalité des annonces de ventes aux enchères en France.</p>
	</div>
</footer>
</body>
</html>