package com.ynov.webfullstack.back.Service;

import com.ynov.webfullstack.back.Models.Recette;
import com.ynov.webfullstack.back.Repositories.RecetteRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class RecetteService {

    @Autowired
    private RecetteRepository recetteRepository;

    public Optional<Recette> getRecette(final long id) {
        return recetteRepository.findById(id);
    }

    public Iterable<Recette> getRecettes() {
        return recetteRepository.findAll();
    }

    public void deleteRecette(final long id) {
        recetteRepository.deleteById(id);
    }

    public Recette saveRecette(Recette recette) {
        Recette savedRecette = recetteRepository.save(recette);
        return savedRecette;
    }

}