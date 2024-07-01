package com.ynov.webfullstack.back.Controllers;

import com.ynov.webfullstack.back.Models.Ingredient;
import com.ynov.webfullstack.back.Models.Recette;
import com.ynov.webfullstack.back.Service.IngredientService;
import com.ynov.webfullstack.back.Service.RecetteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Controller
public class IngredientController {

    @Autowired
    private IngredientService ingredientService;

    @GetMapping("/ingredient/{id}")
    public Optional<Ingredient> getIngredient(long id){
        return ingredientService.getIngredient(id);
    }

    @GetMapping("/ingredients")
    public Iterable<Ingredient> getIngredient() {
        return ingredientService.getIngredients();
    }

    @PostMapping("/ingredient")
    public void saveIngredient(@RequestBody Ingredient ingredient) {
        ingredientService.saveIngredient(ingredient);
    }
    @PostMapping("/ingredient/{id}")
    public void deleteIngredient(long id){
        ingredientService.deleteIngredient(id);
    }
}
