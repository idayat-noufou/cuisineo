package com.ynov.webfullstack.back.Repositories;

import com.ynov.webfullstack.back.Models.Recette;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecetteRepository extends CrudRepository<Recette, Long> {

}