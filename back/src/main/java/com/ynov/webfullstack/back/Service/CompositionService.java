package com.ynov.webfullstack.back.Service;


import com.ynov.webfullstack.back.Models.Composition;
import com.ynov.webfullstack.back.Repositories.CompositionRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class CompositionService {

    @Autowired
    private CompositionRepository compositionRepository;

    public Optional<Composition> getComposition(final long id) {
        return compositionRepository.findById(id);
    }

    public Iterable<Composition> getCompositions() {
        return compositionRepository.findAll();
    }

    public void deleteComposition(final long id) {
        compositionRepository.deleteById(id);
    }

    public Composition saveComposition(Composition composition) {
        Composition savedComposition = compositionRepository.save(composition);
        return savedComposition;
    }

}