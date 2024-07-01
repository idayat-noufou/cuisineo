package com.ynov.webfullstack.back.Models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "composition")
public class Composition {

    @EmbeddedId
    private CompositionKey id;

    @ManyToOne
    @MapsId("recetteId")
    @JoinColumn(name = "recette_id")
    private Recette recette;

    @ManyToOne
    @MapsId("ingredientId")
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    @Column(name="quantite")
    private int quantite;



    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

}