package com.ynov.webfullstack.back.Controllers;

import com.ynov.webfullstack.back.Models.Recette;
import com.ynov.webfullstack.back.Service.RecetteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;
import java.util.UUID;

@RestController
public class RecetteController {

    @Autowired
    private RecetteService recetteService;

    @GetMapping("/recettes/{id}")
    public Optional<Recette> getRecette(@PathVariable Long id){
        return recetteService.getRecette(id);
    }

    @GetMapping("/recettes/")
    public Iterable<Recette> getRecettes() {
        return recetteService.getRecettes();
    }

    @PostMapping("/recettes")
    public Recette saveRecette(@RequestBody Recette recette) {

        return recetteService.saveRecette(recette);
    }

    @GetMapping("/recettes/{keyword}")
    public Iterable<Recette> getRecettesByKeyword( @RequestBody String keyword) {
        return recetteService.getRecettesByKeyword(keyword);
    }


    @DeleteMapping("/recette/{id}")
    public void deleteRecette(Long id){
        recetteService.deleteRecette(id);
    }
}