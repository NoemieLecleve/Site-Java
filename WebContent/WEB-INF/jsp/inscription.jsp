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
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
		<title>Inscription</title>
	</head>
	<body>
		<!-- ****** -->
		<!-- HEADER -->
		<!-- ****** -->
		<header>
			<strong>Ench�rissez, remportez, profitez !</strong>
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
					<legend>Inscription</legend>
					
					<!-- FORMULAIRE PRINCIPALE -->
					<div id="formulairePrincipal" class="background">
						<!-- FORMULAIRE GAUCHE -->
						<div id="formGauche">
							<div>
								<label for="pseudo">Pseudo</label>
								<input id="pseudo" type="text" name="pseudo">							
							</div>
							<div>
								<label for="prenom">Pr�nom</label>
								<input id="prenom" type="text" name="prenom">							
							</div>
							<div>
								<label for="telephone">T�l�phone</label>
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
								<input id="nom" type="text" name=""nom"">							
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
								<label for="passwordConfirme">Code postal</label>
								<input id="passwordConfirme" type="password" name="passwordConfirme">							
							</div>						
						</div>			  
					</div>
					<!-- Fin formulaire principale -->
					
					<!-- BOUTONS -->
					<div>
						<button class="btn btn-primary">Cr�er</button>
						<button class="btn btn-info">Annuler</button>
					</div>				
				</fieldset>
			</form>
		</main>
		
	</body>
</html>