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
	
	<title>Détail de la Vente</title>
</head>
<body>
	<header>

       <%@ include file="header.jsp" %>

	</header>
	 
<main class="connexion">	
	<form method="GET" action="DetailVente">
		<h2>Détail de la vente</h2>
		  <div class=" container">	
		  <div>
			 <img  src="${article.imagePath}" alt="image article" class="rounded float-left mr-5 border" id="detailimg">
			</div> 		 
			    <table class="table table-striped col-8 mt-4">
				  <thead class="table-info">
				    <tr>
				      <th scope="col" colspan="2" id="information">${article.nomArticle}</th>
				    </tr>
				  </thead>
				  <tbody>
				    <tr>
				      <th scope="row">Description</th>
				      <td>${article.description}</td>
				    </tr>
				    <tr >
 
				      <th scope="row" >Catégorie</th>
				      <td>${article.categorieArticle.libelle}</td>
 
				    </tr>
				    <tr>
				      <th scope="row">Meilleur offre</th>
				      <td>800&euro;</td>
				    </tr>
				      <tr>
				      <th scope="row">Mise à prix</th>
				      <td>${article.miseAPrix}&euro;</td>
				    </tr>
				      <tr>
				      <th scope="row">Fin de l'enchère</th>
				      <td>${article.dateFinEncheres}</td>
				    </tr>
				      <tr>
				      <th scope="row">Lieu de Retrait</th>
				      <td>${article.retrait.rueRetrait}, ${article.retrait.villeRetrait}, ${article.retrait.codePostalRetrait}</td>
				    </tr>
				    <tr>
				      <th scope="row">Vendeur</th>
				      <td>${article.utilisateur.pseudo}</td>
				    </tr>
				    <tr>
				      <th scope="row">Ma proposition</th>
				      <td><input type="number" class="form-control" name="miseAPrix"></td>
				     </tr>
				    </tbody>
			  </table>
			</div>
			<a class="btn btn-primary btn-lg " href="">Enchérir</a>	
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