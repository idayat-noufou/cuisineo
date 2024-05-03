package com.example.madrass_back.modeles;

import jakarta.persistence.*;

@Entity
@Table(name = "ingredient")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="nom")
    private String nom;

    @Column(name="prix")
    private int prix;

    public Ingredient(String nom, int prix) {
        this.nom = nom;
        this.prix = prix;
    }

    public Ingredient(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public int getPrix() {
        return prix;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
}