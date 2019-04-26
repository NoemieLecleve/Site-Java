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
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>


		<title>Inscription</title>
	</head>
	<body>
		<!-- ****** -->
		<!-- HEADER -->
		<!-- ****** -->
		<header>
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="http://localhost:8080/ProjetEBAY/">Accueil</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                  
                    <li class="nav-item">
                        <a class="nav-link" href="ConnexionUtilisateur">Se Connecter</a>
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
		
		<!-- ***************** -->
		<!-- CONTENU PRINCIPAL -->
		<!-- ***************** -->
		<main class="inscription">			
		
			<!-- ********** -->
			<!-- FORMULAIRE -->
			<!-- ********** -->
			<form method="POST" action="InscriptionUtilisateur" class="container">
				<fieldset>
				<div class="element3">
					<legend>Inscription</legend>
				</div>	
				<br>
					<!-- FORMULAIRE PRINCIPALE -->
					<div id="formulairePrincipal" class="background">
						<!-- FORMULAIRE GAUCHE -->
						<div id="formGauche">
							<div>
								<label for="pseudo">Pseudo</label>
								<input id="pseudo" type="text" name="pseudo">							
							</div>
							<div>
								<label for="prenom">Prénom</label>
								<input id="prenom" type="text" name="prenom">							
							</div>
							<div>
								<label for="telephone">Téléphone</label>
								<input id="telephone" type="text" name="telephone">							
							</div>
							<div>
								<label for="codePostal">Code postal</label>
								<input id="codePostal" type="text" name="codePostal">							
							</div>
							<div>
								<label for="password">Mot de passe</label>
								<input id="password" type="password" name="password">							
							</div>
						
						</div>
						<!-- FORMULAIRE DROIT -->
						<div id="formDroit">
							<div>
								<label for="nom">Nom</label>
								<input id="nom" type="text" name="nom">							
							</div>
							<div>
								<label for="email">Email</label>
								<input id="email" type="text" name="email">							
							</div>
							<div>
								<label for="rue">Rue</label>
								<input id="rue" type="text" name="rue">							
							</div>
							<div>
								<label for="ville">Ville</label>
								<input id="ville" type="text" name="ville">							
							</div>
							<div>
								<label for="passwordConfirme">Confirmer password</label>
								<input id="passwordConfirme" type="password" name="passwordConfirme">							
							</div>						
						</div>			  
					</div>
					<br>
					<!-- Fin formulaire principale -->
					
					<!-- BOUTONS -->
					<div>
						<button class="btn btn-primary">Créer</button>
						<a class="btn btn-info" href="index.jsp">Annuler</a>
					</div>
					<p>${message}</p>				
				</fieldset>
			</form>
		</main>
		
	</body>
</html>