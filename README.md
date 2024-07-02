# Guide de Configuration du Projet Cuisineo

## Prérequis

Assurez-vous d'avoir les éléments suivants installés sur votre système :

- [Docker](https://www.docker.com/products/docker-desktop)
- [Docker Compose](https://docs.docker.com/compose/install/)

## Structure du Projet

```
cuisineo/
├── front/
│   ├── Dockerfile
│   └── ... (autres fichiers du front-end)
├── back/
│   ├── Dockerfile
│   └── ... (autres fichiers du back-end)
├── docker-compose.yml
└── README.md
```

## Démarrage

Suivez les étapes ci-dessous pour configurer et lancer le projet Cuisineo.

### Étape 1 : Cloner le Répertoire

Clonez le répertoire du projet sur votre machine locale.

```sh
git clone https://github.com/votre-nom-utilisateur/cuisineo.git
cd cuisineo
```

### Étape 2 : Construire et Lancer les Conteneurs Docker

Exécutez la commande suivante pour construire et démarrer les conteneurs :

```sh
docker-compose up --build
```

Cette commande va :

- Construire l'image du front-end et démarrer le conteneur `cuisineo_front`.
- Construire l'image du back-end et démarrer le conteneur `cuisineo_back`.
- Télécharger l'image de MySQL et démarrer le conteneur `mysql`.
- Télécharger l'image de phpMyAdmin et démarrer le conteneur `phpmyadmin`.

### Étape 3 : Accéder aux Services

Une fois les conteneurs en cours d'exécution, vous pouvez accéder aux différents services :

- **Application Front-end** : [http://localhost:4200](http://localhost:4200)
- **API Back-end** : [http://localhost:3080](http://localhost:3080)
- **phpMyAdmin** : [http://localhost:8081](http://localhost:8081)

### Étape 4 : Interagir avec la Base de Données

Vous pouvez interagir avec la base de données MySQL en utilisant phpMyAdmin. Utilisez les identifiants suivants pour vous connecter :

- **Nom d'utilisateur** : root
- **Mot de passe** : sa
- **Serveur** : mysql

### Variables d'Environnement

Le service back-end utilise les variables d'environnement suivantes, définies dans le fichier `docker-compose.yml` :

- `SPRING_DATASOURCE_URL` : URL JDBC pour la connexion à la base de données MySQL.
- `SPRING_DATASOURCE_USERNAME` : Nom d'utilisateur de la base de données.
- `SPRING_DATASOURCE_PASSWORD` : Mot de passe de la base de données.
- `SPRING_DATASOURCE_DRIVER_CLASS_NAME` : Nom de la classe du driver JDBC.
- `SPRING_JPA_PROPERTIES_HIBERNATE_DIALECT` : Dialecte Hibernate pour MySQL.

### Arrêter les Conteneurs

Pour arrêter les conteneurs en cours d'exécution, utilisez la commande suivante :

```sh
docker-compose down
```

Cette commande arrêtera et supprimera tous les conteneurs définis dans le fichier `docker-compose.yml`.

### Dépannage

- **Conflits de Ports** : Si vous rencontrez des conflits de ports, assurez-vous que les ports `4200`, `3080`, `3306` et `8081` ne sont pas utilisés par d'autres services.
- **Problèmes de Connexion à la Base de Données** : Assurez-vous que le conteneur `mysql` est en cours d'exécution et vérifiez les variables d'environnement pour les détails corrects de connexion à la base de données.

## Conclusion

Vous avez configuré et lancé avec succès le projet Cuisineo en utilisant Docker et Docker Compose. Vous pouvez maintenant commencer à développer et tester votre application. Pour le développement ultérieur, référez-vous aux `Dockerfile` respectifs et à toute autre documentation spécifique au projet.s