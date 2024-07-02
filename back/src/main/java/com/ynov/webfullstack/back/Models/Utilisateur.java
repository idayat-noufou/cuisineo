package com.ynov.webfullstack.back.Models;
import jakarta.persistence.*;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;
@Entity
@Table(name = "utilisateur")
public class Utilisateur implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="prenom")
    private String prenom;

    @Column(name="nom")
    private String nom;

    @Column(name="email")
    private String email;

    //    @UniqueElements
    @Column(name="mdp")
    private String mdp;

    @Column(name="role")
    private String role;




    @OneToMany(mappedBy = "utilisateurRecettes")
    private List<Recette> recettes;



    @ManyToMany(mappedBy = "utilisateurs")
    private List<Recette> recettesfavorites;

    public Utilisateur() {
    }

    public List<Recette> getRecettesfavorites() {
        return recettesfavorites;
    }

    public void setRecettesfavorites(List<Recette> recettesfavorites) {
        this.recettesfavorites = recettesfavorites;
    }

    public void addRecette(Recette recette) {
        this.recettesfavorites.add(recette);
    }

    public void deleteRecette(Recette recette) {
        this.recettesfavorites.remove(recette);
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }


    @Override public String toString() {
        return "User{" +
                "id=" + id +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                '}';
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return mdp;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

