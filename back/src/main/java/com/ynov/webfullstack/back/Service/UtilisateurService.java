package com.ynov.webfullstack.back.Service;
import com.ynov.webfullstack.back.Models.Recette;
import com.ynov.webfullstack.back.Models.Utilisateur;
import com.ynov.webfullstack.back.Repositories.RecetteRepository;
import com.ynov.webfullstack.back.Repositories.UtilisateurRepository;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
public class UtilisateurService {

    private UtilisateurRepository utilisateurRepository;

    private RecetteRepository recetteRepository;


    // fonction pour ajouter un favori
    public Utilisateur addFavori(UUID id, UUID recetteId) {

        Recette recette = recetteRepository.findById(recetteId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Cannot find recipe with the specified id"));
        Utilisateur utilisateur = utilisateurRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "User with id " + id + " does not exist"));
        utilisateur.addRecette(recette);
        return utilisateurRepository.save(utilisateur);
    }


}
