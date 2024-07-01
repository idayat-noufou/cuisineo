package com.ynov.webfullstack.back.Controllers;
import com.ynov.webfullstack.back.Models.Utilisateur;
import com.ynov.webfullstack.back.Service.UtilisateurService;

import com.ynov.webfullstack.back.Repositories.UtilisateurRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin("*")
public class UtilisateurController {
    @Autowired
    private UtilisateurService utilisateurService;

    @PutMapping("/utilisateurs/{id}/addFavori")
    public Utilisateur addFavori(@PathVariable UUID id, @RequestBody UUID recetteId) {
        return utilisateurService.addFavori(id, recetteId);
    }

}
