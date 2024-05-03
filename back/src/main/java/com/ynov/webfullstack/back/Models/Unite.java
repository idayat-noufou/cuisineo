package com.ynov.webfullstack.back.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "unite")
public class Unite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="nom")
    private String nom;

    @Column(name="valeur")
    private int valeur;

    public Unite(String nom, int valeur) {
        this.nom = nom;
        this.valeur = valeur;
    }

    public Unite() {}

    public String getNom() {
        return nom;
    }

    public int getValeur() {
        return valeur;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }
}