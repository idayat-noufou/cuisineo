package com.example.madrass_back.modeles;

import jakarta.persistence.*;

@Entity
@Table(name = "composition")
public class Composition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="ingredient_id")
    private int ingredient_id;

    @Column(name="quantite")
    private int quantite;

    public Composition(int ingredient_id, int quantite) {
        this.ingredient_id = ingredient_id;
        this.quantite = quantite;
    }

    public int getIngredient_id() {
        return ingredient_id;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setIngredient_id(int ingredient_id) {
        this.ingredient_id = ingredient_id;
    }
}