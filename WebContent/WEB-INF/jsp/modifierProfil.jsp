<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
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
             	<ul>
	                 <li class="nav-item dropdown">
					    <select class="mdb-select md-form mr-2 font-weight-light" >
							  <option  value="" disabled selected>Objets par catégorie</option>
							  
							  <c:forEach var="categorie" items="${listeCategories}">
							  
							  <option value="categorie">${categorie.libelle}</option>
							  
							  </c:forEach>
						</select>
	                        
	                   </li>
                  </ul>
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
					<legend>Mon profil</legend>
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
					<div>
						<p>Credit</p>
					</div>
					<!-- BOUTONS -->
					<div>
						<button class="btn btn-primary">Enregistrer</button>
						<button class="btn btn-info">Supprimer mon compte</button>
					</div>
					<p>${message}</p>				
				</fieldset>
			</form>
		</main>
		
</body>
</html>