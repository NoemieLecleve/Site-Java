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
            <a class="navbar-brand" href="http://localhost:8080/ProjetEBAY/">Accueil</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                  
                    <li class="nav-item">
                        <a class="nav-link" href="InscriptionUtilisateur"><i class="fas fa-sign-in-alt"></i>S'inscrire</a>
                    </li>
                   </ul>
             <form class="form-inline my-2 my-lg-0">
             
                 <li class="nav-item dropdown">
				 
				    <select class="mdb-select md-form mr-2 font-weight-light" >
						  <option  value="" disabled selected>Objets par catégorie</option>
						  
						  <c:forEach var="categorie" items="${listeCategories}">
						  
						  <option value="categorie">${categorie.libelle}</option>
						  
						  </c:forEach>
					</select>
                        
                   </li>
                    
                    <input class="form-control mr-sm-2" type="search" placeholder="Rechercher une vente" aria-label="Search">
                    <button class="btn btn-outline-secondary my-2 my-sm-0" type="submit">Recherche</button>
                </form>
            </div>
 
        </nav>
</header>


<main class="connexion"> 		  
	  		   	
		
		<form method="post" action="ConnexionUtilisateur" class="container">
		  <fieldset>
		  <div class="jaune">
		  	<legend>Connexion</legend>
		  </div>
		   <div class="background">
		   <div class="main-padding login-wrapper">
            <div class="split-50 border">
                <div class="split-wrap">
                  <strong class="text-center ">Connectez-vous</strong>
	            <form class="px-4 py-3">
	                <div class="form-group">
	                    <label for="exampleDropdownFormEmail1">Adresse email ou Pseudo :</label>
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
	            <a class="dropdown-item text-muted" href="s'inscrir">Pas encore de compte ? Inscrivez-vous gratuitement</a>
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
</body>
</html>