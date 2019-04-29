
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

       <c:choose>
		    <c:when test="${sessionScope.sessionIdUtilisateur != null}">
		     <nav class="navbar navbar-expand-lg navbar-light bg-light">
	            <a class="navbar-brand" href="home">Accueil</a>
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
	                        <a class="nav-link" href="RecupererUtilisateur">${sessionPseudoUtilisateur}</a>
	                    </li>
	                    <li class="nav-item">
	                        <a class="nav-link" href="DeconnexionServlet">Se Déconnecter</a>
	                    </li>
	                   </ul>
	                <form class="form-inline my-2 my-lg-0">
	                <ul>
		                 <li class="nav-item dropdown">
						    <select class="mdb-select md-form mr-2 mt-3 font-weight-light" >
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
            <a class="navbar-brand" href="home">Accueil</a>
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
						  <option   disabled selected>Objets par catégorie</option>
						  
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