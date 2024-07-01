package com.ynov.webfullstack.back.Models;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "ingredient")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name="nom")
    private String nom;

    @Column(name="prix")
    private int prix;

    @OneToMany(mappedBy = "ingredient")
    private List<Composition> composition;


    public Ingredient(String nom, int prix) {
        this.nom = nom;
        this.prix = prix;
    }

    public Ingredient(String nom) {
        this.nom = nom;
    }

    public Ingredient() {}

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