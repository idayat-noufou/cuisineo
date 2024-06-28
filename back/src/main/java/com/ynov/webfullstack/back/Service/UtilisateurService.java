package com.ynov.webfullstack.back.Service;
import com.ynov.webfullstack.back.Models.Recette;
import com.ynov.webfullstack.back.Models.Utilisateur;
import com.ynov.webfullstack.back.repositories.RecetteRepository;
import com.ynov.webfullstack.back.repositories.UtilisateurRepository;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class UtilisateurService {

    private UtilisateurRepository utilisateurRepository;

    private RecetteRepository recetteRepository;


    public Utilisateur addRecetteToUser(Long id, Long recetteId) {

        Recette recette = recetteRepository.findById(recetteId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Cannot find recipe with the specified id"));
        Utilisateur utilisateur = utilisateurRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "User with id " + id + " does not exist"));
        utilisateur.addRecette(recette);
        return utilisateurRepository.save(utilisateur);
    }

    public List<Utilisateur> getUtilisateurs() {
        return utilisateurRepository.findAll();
    }

}
