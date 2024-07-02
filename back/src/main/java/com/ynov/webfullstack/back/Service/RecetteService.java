package com.ynov.webfullstack.back.Service;

import com.ynov.webfullstack.back.Models.Recette;
import com.ynov.webfullstack.back.Repositories.RecetteRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.UUID;

@Service
public class RecetteService {

    @Autowired
    private RecetteRepository recetteRepository;

    public Optional<Recette> getRecette(Long id) {
        return recetteRepository.findById(id);
    }

    public Iterable<Recette> getRecettes() {
        return recetteRepository.findAll();
    }

    public void deleteRecette(Long id) {
        recetteRepository.deleteById(id);
    }

    public Recette saveRecette(Recette recette) {
        if (!recetteRepository.findByTitre(recette.getTitre()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "A recipe with the same name already exists");
        }
        System.out.println(recette);
        return recetteRepository.save(new Recette(recette.getNb_personnes(), recette.getTitre(), recette.getTemps(), recette.getInstruction()));
    }

    public Iterable<Recette> getRecettesByKeyword(String keyword) {
        return recetteRepository.findByTitreContaining(keyword);
    }
}