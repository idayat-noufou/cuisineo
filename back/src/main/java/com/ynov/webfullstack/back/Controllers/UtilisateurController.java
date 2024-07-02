package com.ynov.webfullstack.back.Controllers;
import com.ynov.webfullstack.back.Models.Recette;
import com.ynov.webfullstack.back.Models.Utilisateur;
import com.ynov.webfullstack.back.Service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin("*")
public class UtilisateurController {
    @Autowired
    private UtilisateurService utilisateurService;


    @GetMapping("userProfile/{id}")
    public Optional<Utilisateur> getUtilisateur(@PathVariable UUID id){
        return utilisateurService.getUserProfile(id);
    }
    @PutMapping("/utilisateurs/{id}/addFavori")
    public Utilisateur addFavori(@PathVariable UUID id, @RequestBody Long recetteId) {
        return utilisateurService.addFavori(id, recetteId);
    }

    @GetMapping("/utilisateurs/{id}/recettes")
    public List<Recette> getRecettesForUtilisateur(@PathVariable UUID id) {
        return utilisateurService.getRecettesForUtilisateur(id);
    }
    @GetMapping("/utilisateurs/{id}/favoris")
    public List<Recette> getFavoris(@PathVariable UUID id) {
        return utilisateurService.getFavoris(id);
    }
    @DeleteMapping("/utilisateurs/{id}/deleteFavori")
    public void deleteFavori(@PathVariable UUID id, @RequestBody Long recetteId) {
        utilisateurService.deleteFavori(id, recetteId);
    }

}