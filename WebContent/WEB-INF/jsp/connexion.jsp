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
	<strong>Enchérissez, remportez, profitez !</strong>
</header>
<main class="connexion">
		
		<form method="post" action="ConnexionUtilisateur" class="container">
		  <fieldset>
		  <legend>Connexion</legend>
		   <div class="background">
			  <div class="form-group text-center">
				  <label for="identifiant">Identifiant </label>
				  <input type="text" name="identifiant" id="identifiant" placeholder="Votre pseudo" value="" required />
			  </div>
			  
			   <div class="form-group text-center">
	   			<label for="motdepasse">Mot de passe </label>
			     <input type="password" name="motdepasse" id="motdepasse" placeholder="Votre mot de passe" value="" required />
		  	  </div> 
		  	       
		  	  <div>
		      	<button type="submit" value="" id="connexion" class="btn btn-primary">Connexion</button>
		      </div>
		      <div>
			      <input type="checkbox" id="savemdp" name="savemdp">
		  		  <label for="savemdp">Se souvenir de moi</label>
		  		  <a href="#">Mot de passe oublié</a>
	  		  </div>
	  		  <div>	 
	  		  	<button type="submit" value="" id="compte" class="btn btn-info">Créer un compte</button>
	  		  </div>
	  		  
	  		   	<p class="erreur"> ${message}</p>	

	  		  <!--   Vérification de la présence d'un objet utilisateur en session -->
                <c:if test="${!empty sessionScope.sessionUtilisateur}">
                    <!-- Si l'utilisateur existe en session, alors on affiche son pseudo. -->
                    <p>${sessionScope.sessionUtilisateur.pseudo}</p>             
                </c:if> 
             </div>
  		  </fieldset>
		</form>		
</main>
</body>
</html>