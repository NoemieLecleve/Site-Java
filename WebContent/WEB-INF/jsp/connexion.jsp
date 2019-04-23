<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/style.css" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>
	<p>Enchérissez, remportez, profitez !</p>
	
	<main class="connexion">
		<h1></h1>
		<form method="post" action="ConnexionUtilisateur" class="col-lg-12">
		  <fieldset>
		  <legend>Connexion</legend>
			  <div class="form-group">
				  <label for="identifiant">Identifiant :</label>
				  <input type="text" name="identifiant" id="identifiant" class="form-control" 
				  		 value="<c:out value="${utilisateur.identifiant}"/>" required />
			  </div>
			   	<p class="erreur"> ${form.erreur['identifiant']}</p>
			   <div class="form-group">
			      <label for="motdepasse">Mot de passe :</label>
			      <input type="password" name="motdepasse" id="motdepasse" class="form-control" required />
		  	  </div> 
		  	    <p class="erreur"> ${form.erreur['motdepasse']}</p>	    
		  	  <div>
		      	<button type="submit" value="" id="connexion" class="btn btn-primary">Connexion</button>
		      </div>
		      <div>
			      <input type="checkbox" id="savemdp" name="savemdp">
		  		  <label for="savemdp">Se souvenir de moi</label>
		  		  <a href="#">Mot de passe oublié</a>
	  		  </div>
	  		  <div>	 
	  		  	<button type="submit" value="" id="compte">Créer un compte</button>
	  		  </div>
	  		  
	  		  <!--   Vérification de la présence d'un objet utilisateur en session -->
                <c:if test="${!empty sessionScope.sessionUtilisateur}">
                    <!-- Si l'utilisateur existe en session, alors on affiche son adresse email. -->
                    <p>${sessionScope.sessionUtilisateur.pseudo}</p>             
                    <p class="succes">${form.message}</p>
                </c:if>   
  		  </fieldset>
		</form>		
	</main>
</body>
</html>