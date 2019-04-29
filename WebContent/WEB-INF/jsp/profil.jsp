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
<title>Profil</title>
</head>
<body>
	<header>
		<%@ include file="header.jsp" %>
	</header>
	<main class="connexion">	
		<form method="GET" action="RecupererUtilisateur" class="container">
			<h2>Profil</h2>
			<table class="table table-striped ">
				  <thead class="table-info">
				    <tr>
				      <th scope="col" colspan="2" id="information">Mes informations</th>
				    </tr>
				  </thead>
				  <tbody>
				    <tr>
				      <th scope="row">Pseudo</th>
				      <td>${utilisateur.pseudo}</td>
				    </tr>
				    <tr >
				      <th scope="row" >Nom</th>
				      <td>${utilisateur.nom}</td>
				    </tr>
				    <tr>
				      <th scope="row">Prénom</th>
				      <td>${utilisateur.prenom}</td>
				    </tr>
				      <tr>
				      <th scope="row">Email</th>
				      <td>${utilisateur.email}</td>
				    </tr>
				      <tr>
				      <th scope="row">Téléphone</th>
				      <td>${utilisateur.telephone}</td>
				    </tr>
				      <tr>
				      <th scope="row">Rue</th>
				      <td>${utilisateur.rue}</td>
				    </tr>
				      <tr>
				      <th scope="row">Code Postal</th>
				      <td>${utilisateur.codePostal}</td>
				    </tr>
				      <tr>
				      <th scope="row">Ville</th>
				      <td>${utilisateur.ville}</td>
				    </tr>
				  </tbody>
			</table>
			<a class="btn btn-primary mr-2" href="ModifierProfil.jsp">Modifier</button>
			<a class="btn btn-info" href="index.jsp">Annuler</a>
		</form>
	</main>
</body>
</html>