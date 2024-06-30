package com.ynov.webfullstack.back.Controllers;
import com.ynov.webfullstack.back.Models.Ingredient;
import com.ynov.webfullstack.back.Models.Recette;
import com.ynov.webfullstack.back.Models.Utilisateur;
import com.ynov.webfullstack.back.Service.RecetteService;
import com.ynov.webfullstack.back.Service.UtilisateurService;
import com.ynov.webfullstack.back.Repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin("*")
public class UtilisateurController {
    @Autowired
    private UtilisateurService utilisateurService;

    @PutMapping("/utilisateurs/{id}/addFavori")
    public Utilisateur addFavori(@PathVariable Long id, @RequestBody Long recetteId) {
        return utilisateurService.addFavori(id, recetteId);
    }

}
