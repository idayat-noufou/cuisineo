package com.ynov.webfullstack.back.Service;

import com.ynov.webfullstack.back.Models.Ingredient;
import com.ynov.webfullstack.back.Repositories.IngredientRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Data
@Service
public class IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    public Optional<Ingredient> getIngredient(final UUID id) {
        return ingredientRepository.findById(id);
    }

    public Iterable<Ingredient> getIngredients() {
        return ingredientRepository.findAll();
    }

    public void deleteIngredient(final UUID id) {
        ingredientRepository.deleteById(id);
    }

    public Ingredient saveIngredient(Ingredient ingredient) {
        Ingredient savedIngredient = ingredientRepository.save(ingredient);
        return savedIngredient;
    }

}