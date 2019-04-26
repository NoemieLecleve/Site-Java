<%@ page language="java" contentType="text/html; charset=UTF-8"
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

<title>ENI Enchérisseur</title>

</head>
<body>
     
<header>
       <c:choose>
		    <c:when test="${sessionScope.sessionIdUtilisateur != null}">
		     <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="">Accueil</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                   
                    <li class="nav-item">
                        <a class="nav-link" href="#">Enchères</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Vendre un article</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">${sessionPseudoUtilisateur}</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="DeconnexionServlet">Se Déconnecter</a>
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
		    </c:when>    
		    <c:otherwise>
		    <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="index.jsp">Accueil</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                  
                    <li class="nav-item">
                        <a class="nav-link" href="InscriptionUtilisateur"><i class="fas fa-sign-in-alt"></i>S'inscrire</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="ConnexionUtilisateur"><i class="fas fa-user"></i>Se Connecter</a>
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
		    </c:otherwise>
		</c:choose>
	
</header>
  

<main>
	  <div>
     <h1 class="text-center">Trouvez l'objet de vos rêves </h1>
     </div>
        <br>
	  <div class="element row" >
        <c:forEach items="${listeArticles}" var="article"> 
        		      
			        <div class="card  text-center element2" style="width: 18rem;">
			            <img class="card-img-top" id ="img" src="${article.imagePath}" alt="image article">
			            <div class="card-body">
			                <h5 class="card-title">${article.nomArticle} </h5>
			                <h6 class="card-text">date de début: ${article.dateFinEncheres}</h6>
			                <h6 class="card-text"> ${article.prixVente}€</h6>
			
			                <a href="#" class="btn btn-primary">Voir l'ojet</a>
		                </div>
		                
		            </div>
	         
       </c:forEach>
    </div>
</main>
</body>
</html>