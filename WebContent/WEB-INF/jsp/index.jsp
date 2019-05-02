<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://fonts.googleapis.com/css?family=Oxygen|Nunito|PT+Sans" rel="stylesheet">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
<link href="css/style.css" rel="stylesheet">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

<title>ENI Enchèrisseur</title>

</head>
<body>
     
<header>

       <%@ include file="header.jsp" %>

</header>
  

<main class="index"> 

   
      <div class="row">
		<div class="col" id="nopadding">
	      <c:if test="${sessionScope.sessionIdUtilisateur != null}">
	      <!--  Si l'utilisateur est connecté, on affiche les select -->
	       <form>
			  <div class="form-group row col-11" id="nopadding">
			    <input type="text" class="form-control" id="texte" placeholder="Nom de l'article ?">
			  </div>
			  <div class="form-group row">
			     <select class="mdb-select md-form ml-3 mt-1 font-weight-light"  name="noCategorie">
					  <option  value="" disabled selected>Objets par catégorie</option>
					  
					  <c:forEach var="categorie" items="${listeCategories}">
					  
					  <option value="${categorie.noCategorie}">${categorie.libelle}</option>
					  
					  </c:forEach>
				</select>    
			  </div>
			  <fieldset class="form-group">
			    <div class="row text-left">	      
			      <div class="col-sm-12">
			      
			      <div class="form-check">
			         <input type="radio" class="custom-control-input" id="Ventes" name="cocher" value="1">
                     <label class="custom-control-label" for="Ventes">Ventes</label>
				    </div>
			        <div class="form-check">
			         <label class="form-check-label">
					    <input type="radio" class="form-check-input" name="Ventes1">Ventes términées
					  </label>
			        </div>
			        <div class="form-check">
			          <label class="form-check-label">
					    <input type="radio" class="form-check-input" name="Ventes1">Ventes non débutées
					  </label>
			        </div>
			        <div class="form-check">
			          <label class="form-check-label">
					    <input type="radio" class="form-check-input" name="Ventes1">Mes ventes en cours
					  </label>
			        </div>
			       </div>
			       <div class="col-sm-12">
			      
			      <div class="form-check">
			         <input type="radio" class="custom-control-input" id="Achats" name="cocher" value="2">
                     <label class="custom-control-label" for="Achats">Achats</label>
				    </div>
			        <div class="form-check">
			         <label class="form-check-label">
					    <input type="radio" class="form-check-input" name="Achats1">Enchères ouvertes
					  </label>
			        </div>
			        <div class="form-check">
			          <label class="form-check-label">
					    <input type="radio" class="form-check-input" name="Achats1">Mes enchères en cours
					  </label>
			        </div>
			        <div class="form-check">
			          <label class="form-check-label">
					    <input type="radio" class="form-check-input" name="Achats1">Mes enchères remportées
					  </label>
			        </div>
			       </div>
			    </div>
			  </fieldset>
			  <div class="form-group row">
			    <div class="col-sm-10">
			      <button type="submit" class="btn btn-outline-info btn-lg btn-block">Rechercher</button>
			    </div>
			  </div>
			</form>
		  </c:if>
		  </div>
		  <div class="col-10" id="nopadding">
	            <div id="imgheader">
			   		<h1 class="text-center" id="h1">Trouvez l'objet de vos rêves ! </h1>
			</div>
	  </div>
	  </div>
	     
	  <br>
	  
	  <div class="container">
		  <div class="row">
		    <div class="col-sm-1"></div>
		      <div class="col-sm-10 element2 ">
      		     <c:forEach items="${listeArticles}" var="article">     
			         <div class="card  text-center mt-3" style="width: 18rem;">
			            <img class="card-img-top" id ="img" src="${article.imagePath}" alt="image article">
			               <div class="card-body">
			                <h5 class="card-title">${article.nomArticle} </h5>
			                <h6 class="card-text">date de début: ${article.dateFinEncheres}</h6>
			                <h6 class="card-text"> ${article.miseAPrix}&euro;</h6>
			                <a href="DetailVente?articleId=${article.noArticle}" class="btn btn-primary">détail Vente</a>
		                </div>		                
		             </div>
		        </c:forEach>
    		</div>
    	<div class="col-sm-1"></div>
       </div>
       </div>
</main>
</body>
</html>