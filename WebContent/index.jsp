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
<title>Insert title here</title>
</head>
<body>
<header>
	<strong>Ench�rissez, remportez, profitez !</strong>
</header>
<main class="index">
	<nav class="first-nav">
		<ul class="nav nav-pills">
		  <li class="nav-item">
		    <a class="nav-link active" href="InscriptionUtilisateur">S'inscrire</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" href="ConnexionUtilisateur">Se connecter</a>
		  </li>
		</ul>
	</nav>
	<h1>Liste des Ench�res</h1>
	<strong>Filtres : </strong>	
	<nav class="navbar navbar-light bg-light">
	  <form class="form-inline">
	    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
	    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">recherche</button>
	  </form>
	</nav>
	<label>Cat�gorie : </label>
	<select>
		<option value="tout">Toutes</option>
    	<option value="infor">Informatique</option>
    	<option value="meuble">Ameublement</option>
    	<option value="vetement">V�tement</option>
    	<option value="sport">Sport & Loisirs</option>
	</select>
	<!-- Div Cadre Rechercher -->
	<section>
		<article>
		<div><!-- Image  --></div>
		<div>
			<h2>Meuble </h2>
			<p>Prix : </p>
			<p>Fin de l'ench�re : </p>
			<p>Vendeur : </p>
		</div>
		</article>
	</section>
</main>
</body>
</html>