package com.ynov.webfullstack.back.Service;

import com.ynov.webfullstack.back.Models.Unite;
import com.ynov.webfullstack.back.Repositories.UniteRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class UniteService {

    @Autowired
    private UniteRepository uniteRepository;

    public Optional<Unite> getUnite(final long id) {
        return uniteRepository.findById(id);
    }

    public Iterable<Unite> getUnites() {
        return uniteRepository.findAll();
    }

    public void deleteUnite(final long id) {
        uniteRepository.deleteById(id);
    }

    public Unite saveUnite(Unite unite) {
        Unite savedUnite = uniteRepository.save(unite);
        return savedUnite;
    }

}