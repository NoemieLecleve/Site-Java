<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

<title>Modifier votre profil</title>
</head>
<body>
	<header>
			<%@ include file="header.jsp" %>
		</header>
		
		<!-- ***************** -->
		<!-- CONTENU PRINCIPAL -->
		<!-- ***************** -->
		<main class="inscription">			
		
			<!-- ********** -->
			<!-- FORMULAIRE -->
			<!-- ********** -->
			<form method="POST" action="ModifierUtilisateur" class="container">
				<fieldset>
				<div class="element3">
					<legend>Modifier Mon profil</legend>
				</div>	
				<br>
					<!-- FORMULAIRE PRINCIPALE -->
					<div id="formulairePrincipal" class="background">
						<!-- FORMULAIRE GAUCHE -->
						<div id="formGauche">
							<div>
								<label for="pseudo">Pseudo</label>
								<input id="pseudo" type="text" name="pseudo" value="${utilisateur.pseudo}">							
							</div>
							<div>
								<label for="prenom">Pr�nom</label>
								<input id="prenom" type="text" name="prenom" value="${utilisateur.prenom}">							
							</div>
							<div>
								<label for="telephone">T�l�phone</label>
								<input id="telephone" type="text" name="telephone" value="${utilisateur.telephone}">							
							</div>
							<div>
								<label for="codePostal">Code postal</label>
								<input id="codePostal" type="text" name="codePostal" value="${utilisateur.codePostal}">							
							</div>
							<div>
								<label for="password">Mot de passe</label>
								<input id="password" type="password" name="password">							
							</div>
							<div>
								<label for="password">Nouveau mot de passe</label>
								<input id="password" type="password" name="nouveauMotPasse">							
							</div>
						
						</div>
						<!-- FORMULAIRE DROIT -->
						<div id="formDroit">
							<div>
								<label for="nom">Nom</label>
								<input id="nom" type="text" name="nom" value="${utilisateur.nom}">							
							</div>
							<div>
								<label for="email">Email</label>
								<input id="email" type="text" name="email" value="${utilisateur.email}">							
							</div>
							<div>
								<label for="rue">Rue</label>
								<input id="rue" type="text" name="rue" value="${utilisateur.rue}">							
							</div>
							<div>
								<label for="ville">Ville</label>
								<input id="ville" type="text" name="ville" value="${utilisateur.ville}">							
							</div>
							<div>
								<label for="passwordConfirme">Confirmer</label>
								<input id="passwordConfirme" type="password" name="passwordConfirme">							
							</div>						
						</div>			  
					</div>
					<br>
					<!-- Fin formulaire principale -->
					<div>
						<p>Credit : ${utilisateur.credit}</p>
					</div>
					<!-- BOUTONS -->
					<div>
						<a class="btn btn-primary mr-2" href="ModifierUtilisateur">Enregister</button>
			            <a class="btn btn-info" href="SupprimerUtilisateur">Supprimer mon Compte</a>
					</div>
					<p>${message}</p>				
				</fieldset>
			</form>
		</main>
		
</body>
</html>