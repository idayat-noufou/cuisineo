package com.ynov.webfullstack.back.Repositories;

import com.ynov.webfullstack.back.Models.Recette;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RecetteRepository extends JpaRepository<Recette, Long> {
    List<Recette> findByTitre(String titre);
    Iterable<Recette> findByTitreContaining(String keyword);

}