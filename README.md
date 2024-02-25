
# Projet de gestion de produits réalisé avec Java Spring boot / Angular

# Configuration

- Veuillez modifier si besoin le fichier application.properties qui se situe dans le répertoire: '/backend/src/main/resources'
- Par défaut, la base de données est mySQL, configuré sur `http://localhost:3306/test` où test est le schéma. 
- Indiquez les login/password d'accès à la BDD
- Le port de l'application est configurable avec le parametre 'server.port=3000'
- ATTENTION l'application va supprimer la table products à chaque lancement ! Une nouvelle table avec des données est ensuite créée


# Backend server

## Prérequis

- Java 17 installation via : 'https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html'
- Maven installation via : 'https://maven.apache.org/install.html' (vérifiez que 'mvn --version' fonctionne)

## Lancement du serveur

- Allez dans le dossier '/back' avec un terminal de commande shell
- éxecutez ces 2 commandes (la première est facultative par la suite, car la deuxième l'inclus):

$ mvn compile
$ mvn package

- Puis éxecuter cette commande pour lancer le serveur :

$ java -jar target/spring-boot-0.0.1-SNAPSHOT.jar

# Conclusion

Vous pouvez maintenant utiliser les api de ce serveur via le serveur Frontend 
(Si vous avez changer le port par défaut, il faut modifier la variable backEndPort dans le fichier products.service.ts qui se situe dans le dossier '\front\src\app\products')

Vous trouverez des screenshots validant le fonctionnant du projet dans le dossier  'API_tests'


## ------------------------------------------------------------------------------------- ##


## Frontend server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

## Json server



## Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory. Use the `--prod` flag for a production build.

## serve a Build

$ npm i -g serve
$ cd dist/product-trial
\$ serve

## Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

## Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via [Protractor](http://www.protractortest.org/).

## Further help

To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI README](https://github.com/angular/angular-cli/blob/master/README.md).
