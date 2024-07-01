package com.ynov.webfullstack.back.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
public class CompositionKey implements Serializable {
    @Column(name="recette_id")
    private UUID recetteId;

    @Column(name="ingredient_id")
    private UUID ingredientId;
}
