package com.ynov.webfullstack.back.Models;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "recette")
public class Recette {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name="titre")
    private String titre;





    @Column(name="nb_personnes")
    private int nb_personnes;

    @Column(name="temps")
    private int temps;

    @Column(name="instruction")
    private int instruction;

    @ManyToOne
    @JoinColumn(name="utilisateur_id")
    private Utilisateur utilisateurRecettes;





    @ManyToMany
    private List<Utilisateur> utilisateursfavoris;

    @OneToMany(mappedBy = "recette")
    private List<Composition> composition;


    public List<Utilisateur> getUtilisateursfavoris() {
        return utilisateursfavoris;
    }

    public void setUtilisateursfavoris(List<Utilisateur> utilisateursfavoris) {
        this.utilisateursfavoris = utilisateursfavoris;
    }
    public Recette(int nb_personnes, String titre, int temps, int instruction) {
        this.nb_personnes = nb_personnes;
        this.titre = titre;
        this.temps = temps;
        this.instruction = instruction;

    }

    public Recette() {}

    public String getTitre() {
        return titre;
    }



    public void setTitre(String titre) {
        this.titre = titre;
    }
    public int getNb_personnes() {
        return nb_personnes;
    }

    public int getTemps() {
        return temps;
    }

    public int getInstruction() {
        return instruction;
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

    public Utilisateur getUtilisateurRecettes() {
        return utilisateurRecettes;
    }

    public void setUtilisateurRecettes(Utilisateur utilisateurRecettes) {
        this.utilisateurRecettes = utilisateurRecettes;
    }
}