# Projet de fin de POEI développeur Java SQLI 2019

## Auteurs :
    *Noémie Leclev*
    *Loubna Tani*
    *Mickaël Leclerc*
    
## Déscription du projet
Réalisation d'un site web de vente aux enchères.
    
## Avancement du projet
** Fonctionnalité implémenté et testé : **
* Se connecter
* S’inscrire
* Page d’accueil
* Se déconnecter
* Afficher un profil
* Modifier mon profil
* Supprimer utilisateur
* Vendre un article
* Lister les enchères en mode déconnecté

## Configuration de la base de donnée

Dans le fichier WebContent/META-INF/context.xml
Pensez à adapter le fichier en fonction de votre configuration, notamment pour les champs :
* url
* username
* password

## Création de la base de donnée
* Créer une base nommé ebay
* Générer le schéma de la base avec le fichier : assets/sql/copie_ebay_ddl_db.sql
* Générer le jeu d'essai avec le fichier : assets/sql/copie_ebay_dml_db.sql

## Déploiement de l'application
Pour déployer le war situé à la racine du projet sur un serveur tomcat version 8xx
* Dans apache-tomcat-8xx/bin
ouvrez une fenêtre de commande puis exécuter >> catalina.bat run
* Dans votre navigateur saisir l'adresse : localhost:8080
* Sur la page d'accueil cliquez sur l'onglet Manager App puis authentifier-vous.
* Ajoutez votre application au context






 
