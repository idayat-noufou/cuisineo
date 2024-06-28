package com.ynov.webfullstack.back.Controllers;

import com.ynov.webfullstack.back.Models.Recette;
import com.ynov.webfullstack.back.Service.RecetteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@Controller
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
    public Recette saveRecette(@RequestBody Recette recette){

        return recetteService.saveRecette(recette);
    }



    @DeleteMapping("/recette/{id}")
    public void deleteRecette(Long id){
        recetteService.deleteRecette(id);
    }
}