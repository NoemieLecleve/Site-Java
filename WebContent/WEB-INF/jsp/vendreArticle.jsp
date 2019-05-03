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
<title>Insert title here</title>
</head>
<body>
	<header>
		<%@ include file="header.jsp" %>
	</header>
<main class="container vente">
		<div class="cadre text-center">
			<h2 class="text-center">Nouvelle vente</h2>
		</div>
		<div class="image">			
		</div>
		<form method="POST" action="VendreArticle" class="form-horizontal ">
		  <div class="form-group row justify-content-center">
		  
		  	<fieldset class="col-4 ">
		  		<legend>Article � vendre</legend>
				    <div class="col-md-10 mb-2">
				      <label for="nomArticle" class="control-label">Article</label>
				      <input type="text" class="form-control" name="nomArticle" value="${article.nomArticle}" required>
				    </div>
				    <div class="col-md-10 mb-2">
				      <label for="description"  class="control-label">Description</label>
				      <textarea type="text" class="form-control" name="description" value="${article.description}" required></textarea>
				    </div>
				    <div class="col-md-10 mb-1">
				    <label for="noCategorie"  class="control-label">Cat�gorie</label>
				     	<select class="custom-select custom-select-sm mb-3" name="noCategorie">
							 <option  value="" disabled selected>Objets par cat�gorie</option>	  
							 <c:forEach var="categorie" items="${listeCategories}">
							 <option value="${categorie.noCategorie}">${categorie.libelle}</option> 
							 </c:forEach>
						</select>  
				    </div>
				    <div class="col-md-10 mb-1">
				    	<label for="imagePath" class="control-label">Photo de l'article</label>
				    	<input type="text" class="form-control" name="imagePath" placeholder="http/..." value="${article.imagePath}" >
				    </div>
				    <div class="col-md-10 mb-1">
				      <label for="miseAPrix"  class="control-label">Mise a prix</label>
				      <input type="number" class="form-control" name="miseAPrix">
					  </div>
					    <div class="col-md-10 mb-2">
					      <label for="dateDebutEncheres"  class="control-label">Debut de l'enchere</label>
					      <input type="date" class="form-control" name="dateDebutEncheres" value="${article.dateDebutEncheres}" required>
					    </div>
					    <div class="col-md-10 mb-2">
					      <label for="dateFinEncheres" class="control-label">Fin de l'enchere</label>
					      <input type="date" class="form-control" name="dateFinEncheres" value="${article.dateFinEncheres}" required>
					   </div>
				 </fieldset>
		    <fieldset class="col-4 col align-self-center" id="retrait">
		    	<legend class="">Retrait</legend>
				    <div class="col-md-10 mb-2">
					    <label for="rue" class="control-label">Rue</label>
			     		<input type="text" class="form-control" name="rueRetrait" value="${utilisateur.rue}" required>
				    </div>
				    <div class="col-md-10 mb-2">
				       <label for="codePostal" class="control-label">Code Postal</label>
		      		   <input type="text" class="form-control" name="codePostalRetrait" value="${utilisateur.codePostal}" required>
				    </div>
				     <div class="col-md-10 mb-2">
				       <label for="ville" class="control-label">Ville</label>
		      		   <input type="text" class="form-control" name="villeRetrait" value="${utilisateur.ville}" required>
				    </div>
		    </fieldset>
		    </div>	  
		   <div class="row justify-content-md-center">
		  		<button class="btn btn-info btn-lg btn-block col-2 mr-3" type="submit">Enregistrer</button>
		  		<button class="btn btn-danger btn-lg col-2" type="reset">Annuler</button>
		  </div>
	</form>
	 	<p class="erreur"> ${message}</p>	
</main>
<footer>
	<nav>
		<a href="home">Acceuil</a><a href="#">FAQ</a><a href="#">Contact</a><a href="ConnexionUtilisateur">Se connecter</a> 
	</nav>
	<div>
	  <strong>Suivez nous sur les r�seaux sociaux !</strong>
		<p> Avec ENI-encheres, achetez aux ench�res, en salle ou sur Internet. 281 commissaires-priseurs garantissent les objets.
		 Ces derniers publient quotidiennement en ligne les informations relatives � leurs prochaines ventes aux ench�res sur le site. 
		 Ils permettent ainsi aux acheteurs du monde entier de consulter gratuitement la quasi-totalit� des annonces de ventes aux ench�res en France.</p>
	</div>
</footer>
</body>
</html>