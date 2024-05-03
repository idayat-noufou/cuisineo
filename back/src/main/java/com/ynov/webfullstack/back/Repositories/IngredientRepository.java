package com.ynov.webfullstack.back.Repositories;

import com.ynov.webfullstack.back.Models.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Long> {

}