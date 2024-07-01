package com.ynov.webfullstack.back.Service;

import com.ynov.webfullstack.back.Models.Unite;
import com.ynov.webfullstack.back.Repositories.UniteRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Data
@Service
public class UniteService {

    @Autowired
    private UniteRepository uniteRepository;

    public Optional<Unite> getUnite(final UUID id) {
        return uniteRepository.findById(id);
    }

    public Iterable<Unite> getUnites() {
        return uniteRepository.findAll();
    }

    public void deleteUnite(final UUID id) {
        uniteRepository.deleteById(id);
    }

    public Unite saveUnite(Unite unite) {
        Unite savedUnite = uniteRepository.save(unite);
        return savedUnite;
    }

}