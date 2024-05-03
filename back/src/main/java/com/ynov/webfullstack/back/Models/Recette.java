package com.ynov.webfullstack.back.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "recette")
public class Recette {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="titre")
    private String titre;

    @Column(name="nb_personnes")
    private int nb_personnes;

    @Column(name="temps")
    private int temps;

    @Column(name="instruction")
    private int instruction;

    @Column(name="owner")
    private int owner;

    public Recette(int nb_personnes, String titre, int temps, int instruction, int owner) {
        this.nb_personnes = nb_personnes;
        this.titre = titre;
        this.temps = temps;
        this.instruction = instruction;
        this.owner = owner;
    }

    public Recette() {}

    public String getTitre() {
        return titre;
    }

    public int getOwner() {
        return owner;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setNb_personnes(int nb_personnes) {
        this.nb_personnes = nb_personnes;
    }

    public void setTemps(int temps) {
        this.temps = temps;
    }

    public void setInstruction(int instruction) {
        this.instruction = instruction;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }
}