package com.ynov.webfullstack.back.Service;
import com.ynov.webfullstack.back.Models.Recette;
import com.ynov.webfullstack.back.Models.Utilisateur;
import com.ynov.webfullstack.back.Repositories.RecetteRepository;
import com.ynov.webfullstack.back.Repositories.UtilisateurRepository;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.awt.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Data
@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private RecetteRepository recetteRepository;



    public List<Recette> getRecettesForUtilisateur(@PathVariable UUID id) {
        return recetteRepository.findByUtilisateursId(id);
    }

    public List<Recette> getFavoris(@PathVariable UUID id) {
        Utilisateur utilisateur = utilisateurRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "User with id " + id + " does not exist"));
        return utilisateur.getRecettesfavorites();
    }
    // fonction pour ajouter un favori
    public Utilisateur addFavori(UUID id, Long recetteId) {

        Recette recette = recetteRepository.findById(recetteId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Cannot find recipe with the specified id"));
        Utilisateur utilisateur = utilisateurRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "User with id " + id + " does not exist"));
        utilisateur.addRecette(recette);
        return utilisateurRepository.save(utilisateur);
    }

    public void deleteFavori(UUID id, Long recetteId) {

        Recette recette = recetteRepository.findById(recetteId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Cannot find recipe with the specified id"));
        Utilisateur utilisateur = utilisateurRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "User with id " + id + " does not exist"));
        utilisateur.deleteRecette(recette);
    }


}
