package com.ynov.webfullstack.back.Controllers;

import com.ynov.webfullstack.back.Models.Composition;
import com.ynov.webfullstack.back.Models.Recette;
import com.ynov.webfullstack.back.Service.CompositionService;
import com.ynov.webfullstack.back.Service.RecetteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class CompositionController {

    @Autowired
    private CompositionService compositionService;

    @GetMapping("/composition/{id}")
    public Optional<Composition> getComposition(long id){
        return compositionService.getComposition(id);
    }

    @GetMapping("/compositions")
    public Iterable<Composition> getCompositions() {
        return compositionService.getCompositions();
    }

    @PostMapping("/composition/{composition}")
    public void saveComposition(Composition composition){
        compositionService.saveComposition(composition);
    }

    @PostMapping("/composition/{id}")
    public void deleteComposition(long id){
        compositionService.deleteComposition(id);
    }
}