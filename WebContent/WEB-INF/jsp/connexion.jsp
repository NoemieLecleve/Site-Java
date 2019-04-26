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
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="ebay.html">Accueil</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Objets par spécialités
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="#">Loisirs</a>
                            <a class="dropdown-item" href="#">Informatique et réseaux</a>
                            <a class="dropdown-item" href="#">Articles pour la maison</a>
                        </div>

                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="#">S'inscrir</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="#">Se Connecter</a>
                    </li>
                </ul>
                <form class="form-inline my-2 my-lg-0">
                    <input class="form-control mr-sm-2" type="search" placeholder="Recherche d'objets..." aria-label="Search">
                    <button class="btn btn-outline-secondary my-2 my-sm-0" type="submit">Recherche</button>
                </form>
            </div>
        </nav>
</header>
<main class="connexion">
		
		<form method="post" action="ConnexionUtilisateur" class="container">
		  <fieldset>
		  <legend>Connexion</legend>
		   <div class="background">
			  <div class="form-group text-center">
				  <label for="identifiant">Identifiant </label>
				  <input type="text" name="identifiant" id="identifiant" placeholder="Votre pseudo" value="" required />
			  </div>
			  
			   <div class="form-group text-center">
	   			<label for="motdepasse">Mot de passe </label>
			     <input type="password" name="motdepasse" id="motdepasse" placeholder="Votre mot de passe" value="" required />
		  	  </div> 
		  	       
		  	  <div>
		      	<button type="submit" value="" id="connexion" class="btn btn-primary">Connexion</button>
		      </div>
		      <div>
			      <input type="checkbox" id="savemdp" name="savemdp">
		  		  <label for="savemdp">Se souvenir de moi</label>
		  		  <a href="#">Mot de passe oublié</a>
	  		  </div>
	  		  <div>	 
	  		  	<button type="submit" value="" id="compte" class="btn btn-info">Créer un compte</button>
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
</body>
</html>