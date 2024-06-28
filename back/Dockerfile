FROM eclipse-temurin:17-jdk-focal

WORKDIR /app

# Copier le répertoire .mvn et les fichiers nécessaires
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# Assurez-vous que mvnw est exécutable
RUN chmod +x mvnw

# Télécharger les dépendances Maven en mode hors-ligne
RUN ./mvnw dependency:go-offline

# Copier le reste des sources
COPY src ./src

# Commande pour exécuter l'application
CMD ["./mvnw", "spring-boot:run"]
