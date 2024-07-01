package com.ynov.webfullstack.back.Controllers;
import com.ynov.webfullstack.back.Models.Unite;
import com.ynov.webfullstack.back.Service.RecetteService;
import com.ynov.webfullstack.back.Service.UniteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;
import java.util.UUID;

@Controller
public class UniteController {

    @Autowired
    private UniteService uniteService;

    @GetMapping("/unite/{id}")
    public Optional<Unite> getUnite(UUID id){
        return uniteService.getUnite(id);
    }

    @GetMapping("/unites")
    public Iterable<Unite> getUnites() {
        return uniteService.getUnites();
    }

    @PostMapping("/unite/{unite}")
    public void saveUnite(Unite unite){
        uniteService.saveUnite(unite);
    }

    @PostMapping("/unite/{id}")
    public void deleteUnite(UUID id){
        uniteService.deleteUnite(id);
    }
}
