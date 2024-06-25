package com.ynov.webfullstack.back.Controllers;

import com.ynov.webfullstack.back.Models.Recette;
import com.ynov.webfullstack.back.Service.RecetteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Controller
public class RecetteController {

    @Autowired
    private RecetteService recetteService;

    @GetMapping("/recettes/{id}")
    public Optional<Recette> getRecette(long id){
        return recetteService.getRecette(id);
    }

    @GetMapping("/recettes")
    public Iterable<Recette> getRecettes() {
        return recetteService.getRecettes();
    }

    @GetMapping("/recettes/{keyword}")
    public Iterable<Recette> getRecettesByKeyword( @RequestBody String keyword) {
        return recetteService.getRecettesByKeyword(keyword);
    }

    @PostMapping("/recette/{recette}")
    public void saveRecette(Recette recette){
        recetteService.saveRecette(recette);
    }

    @PostMapping("/recette/{id}")
    public void deleteRecette(long id){
        recetteService.deleteRecette(id);
    }
}