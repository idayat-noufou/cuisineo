package com.ynov.webfullstack.back.Controllers;

import com.ynov.webfullstack.back.Models.Recette;
import com.ynov.webfullstack.back.Models.Utilisateur;
import com.ynov.webfullstack.back.Service.RecetteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/recettes")
public class RecetteController {

    @Autowired
    private RecetteService recetteService;

    @GetMapping("/{id}")
    public ResponseEntity<Recette> getRecette(@PathVariable Long id) {
        Optional<Recette> recette = recetteService.getRecette(id);
        return recette.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<Iterable<Recette>> getRecettes() {
        Iterable<Recette> recettes = recetteService.getRecettes();
        return ResponseEntity.ok(recettes);
    }

    @PostMapping
    public ResponseEntity<Recette> saveRecette(@RequestBody Recette recette) {
        Recette savedRecette = recetteService.saveRecette(recette);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRecette);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecette(@PathVariable Long id) {
        recetteService.deleteRecette(id);
        return ResponseEntity.noContent().build();
    }

   /* @GetMapping("/search")
    public ResponseEntity<Set<Recette>> searchRecettes(@RequestParam String keyword) {
        Set<Recette> recettes = recetteService.getRecettesByKeyword(keyword);
        return ResponseEntity.ok(recettes);
    }*/

    // Gestion des exceptions globales
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Une erreur s'est produite : " + e.getMessage());
    }

    // Gestion des exceptions spécifiques
    @ExceptionHandler({IllegalArgumentException.class, NoSuchElementException.class})
    public ResponseEntity<String> handleBadRequestExceptions(Exception e) {
        return ResponseEntity.badRequest().body("Requête invalide : " + e.getMessage());
    }
}