FROM node:alpine

WORKDIR /usr/src/app

COPY . .

# Installer Angular CLI globalement
RUN npm install -g @angular/cli

# Installer les dépendances de l'application
RUN npm install

# Exposer le port 4200
EXPOSE 4200

# Commande pour démarrer l'application Angular
CMD ["ng", "serve", "--host", "0.0.0.0"]
