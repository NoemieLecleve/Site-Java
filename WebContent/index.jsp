<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<title>ENI Enchérisseur</title>

</head>
<body>
<header>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="ebay.html">Accueil</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Objets par spécialités
                        </a>

                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="#">Loisirs</a>
                            <a class="dropdown-item" href="#">Informatique et réseaux</a>
                            <a class="dropdown-item" href="#">Articles pour la maison</a>
                        </div>

                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="InscriptionUtilisateur">S'inscrire</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="ConnexionUtilisateur">Se Connecter</a>
                    </li>
                   </ul>
                <form class="form-inline my-2 my-lg-0">
                    <input class="form-control mr-sm-2" type="search" placeholder="Rechercher une vente" aria-label="Search">
                    <button class="btn btn-outline-secondary my-2 my-sm-0" type="submit">Recherche</button>
                </form>
            </div>
        </nav>
</header>
</header>
<main>

     <h1 class="text-center font-weight-light text-secondary ">Trouvez l'objet de vos rêves </h1>

        <br>

        <div class="element">
        <div class="card  text-center element2" style="width: 18rem;">
            <img class="card-img-top" id ="img3" src="https://newvoradio.fr/wp-content/uploads/2017/07/cactus.jpg" alt="Card image cap">
            <div class="card-body">
                <h5 class="card-title">Déco : 8 vases pour des intérieurs originaux</h5>
                <p class="card-text">Début de l'enchère : 25/04/2019 18:00:04</p>
                <p class="card-text"> Fin de l'enchère : 25/04/2019 18:36:54</p>

                <a href="#" class="btn btn-primary">Voir l'ojet</a>
            </div>
            </div>
           <div class="card  text-center element2" style="width: 18rem;">
            <img class="card-img-top" id ="img1" src="https://img.purch.com/o/aHR0cDovL3d3dy5sYXB0b3BtYWcuY29tL2ltYWdlcy93cC9wdXJjaC1hcGkvaW5jb250ZW50LzIwMTkvMDIvbWJwLmpwZw==" alt="Card image cap">
            <div class="card-body">
                <h5 class="card-title">APPLE MACBOOK AIR 13.3</h5>
                <p class="card-text">Début de l'enchère : 25/04/2019 18:00:04</p>
                <p class="card-text"> Fin de l'enchère : 25/04/2019 18:36:54</p>
                <a href="#" class="btn btn-primary">Voir l'ojet</a>
            </div>

        </div>
            <div class="card  text-center element2" style="width: 18rem;">
                <img class="card-img-top" id ="img2" src="https://static1.squarespace.com/static/52ee7408e4b0d94885a12285/t/58ac57663a0411fac304229b/1487689656333/?format=1500w" alt="Card image cap">
                <div class="card-body">
                    <h5 class="card-title">Séjour 4 nuits pour 2 personnes en riad à Marrakech </h5>
                    <p class="card-text">Début de l'enchère : 25/04/2019 18:00:04</p>
                    <p class="card-text"> Fin de l'enchère : 25/04/2019 18:36:54</p>
                    <a href="#" class="btn btn-primary">Voir l'ojet</a>
                </div>

            </div>

        </div>
        </div>
</main>
</body>
</html>