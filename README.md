# Projet de fin de POEI développeur Java SQLI 2019

## Auteurs :
    *Noémie Leclev*
    *Loubna Tani*
    *Mickaël Leclerc*
    
## Description du projet
Réalisation d'un site web de vente aux enchères.
    
## Avancement du projet
** Fonctionnalité implémentée et testée : **
* Se connecter
* S’inscrire
* Page d’accueil
* Se déconnecter
* Afficher un profil
* Modifier mon profil
* Supprimer un utilisateur
* Vendre un article
* Lister les enchères en mode déconnecté

## Configuration de la base de données

Dans le fichier WebContent/META-INF/context.xml
Pensez à adapter le fichier en fonction de votre configuration, notamment pour les champs :
* url
* username
* password

## Création de la base de données
* Créer une base nommée ebay
* Générer le schéma de la base avec le fichier : assets/sql/copie_ebay_ddl_db.sql
* Générer le jeu d'essai avec le fichier : assets/sql/copie_ebay_dml_db.sql

## Déploiement de l'application
Pour déployer le war situé à la racine du projet sur un serveur tomcat version 8xx
* Dans apache-tomcat-8xx/bin
ouvrez une fenêtre de commande puis exécuter >> catalina.bat run
* Dans votre navigateur saisir l'adresse : localhost:8080
* Sur la page d'accueil cliquez sur l'onglet Manager App puis authentifier-vous.
* Ajoutez votre application au context






 
