<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
					<legend>Mon profil</legend>
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
								<label for="prenom">Prénom</label>
								<input id="prenom" type="text" name="prenom" value="${utilisateur.prenom}">							
							</div>
							<div>
								<label for="telephone">Téléphone</label>
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
								<label for="passwordConfirme">Confirmer password</label>
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