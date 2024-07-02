package com.ynov.webfullstack.back.Models.Response;

import com.ynov.webfullstack.back.Models.Utilisateur;

import java.util.UUID;

public class LoginResponse {
    private String token;

    private long expiresIn;


    private Utilisateur user;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
    }
    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }
}
