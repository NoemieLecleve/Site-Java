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

       <%@ include file="header.jsp" %>

</header>
  

<main>
	  <div>
     <h1 class="text-center">Trouvez l'objet de vos rêves </h1>
     </div>
     
     <div class="row">
     
          <div class="border border-light border my-2 rounded element4 " >
	     
		        <div class="custom-control custom-radio mb-3 my-4 ml-4">
				    <input type="radio" class="custom-control-input" id="customControlValidation1" name="enchere1" required >
				    <label class="custom-control-label font-weight-bold" for="customControlValidation1">Achats</label>
				  </div>
				
				  <div class="custom-control custom-checkbox  mb-3 ml-5">
				    <input type= "checkbox" class="custom-control-input" id="customControlValidation2" name="enchere2" required>
				    <label class="custom-control-label font-weight-light" for="customControlValidation2">Enchères Ouvertes</label>
				  </div>
				  
				  <div class="custom-control custom-checkbox  mb-3 ml-5">
				    <input type="checkbox" class="custom-control-input" id="customControlValidation3" name="enchere3" required>
				    <label class="custom-control-label font-weight-light" for="customControlValidation3">Mes enchères en cours</label> 
				  </div>
				  
				  <div class="custom-control custom-checkbox  mb-3 ml-5">
				    <input type="checkbox" class="custom-control-input" id="customControlValidation4" name="enchere4" required>
				    <label class="custom-control-label font-weight-light" for="customControlValidation4">Mes enchères en cours</label> 
				  </div>
		  </div>
		  
		  
		   <div class="border border-light border my-2 rounded element5 " >
		   
		        <div class="custom-control custom-radio mb-3 my-4 ml-4">
				    <input type="radio" class="custom-control-input " id="customControlValidation5" name="enchere1"required >
				    <label class="custom-control-label font-weight-bold" for="customControlValidation5">Mes ventes</label>
				  </div>
				
				  <div class="custom-control custom-checkbox  mb-3 ml-5">
				    <input type= "checkbox" class="custom-control-input" id="customControlValidation6" name="enchere5" required>
				    <label class="custom-control-label font-weight-light" for="customControlValidation6">Mes ventes en cours</label>
				  </div>
				  
				  <div class="custom-control custom-checkbox  mb-3 ml-5">
				    <input type="checkbox" class="custom-control-input" id="customControlValidation7" name="enchere6" required>
				    <label class="custom-control-label font-weight-light" for="customControlValidation7">Ventes non débutées</label> 
				  </div>
				  
				  <div class="custom-control custom-checkbox  mb-3 ml-5">
				    <input type="checkbox" class="custom-control-input" id="customControlValidation8" name="enchere7" required>
				    <label class="custom-control-label font-weight-light" for="customControlValidation8">Ventes terminées</label> 
				  </div>
		  </div>
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