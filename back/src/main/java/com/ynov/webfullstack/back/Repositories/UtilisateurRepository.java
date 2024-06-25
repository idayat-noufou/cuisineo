package com.ynov.webfullstack.back.Repositories;

import com.ynov.webfullstack.back.Models.Utilisateur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UtilisateurRepository extends CrudRepository<Utilisateur, UUID> {
    Optional<Utilisateur> findByEmail(String username);
}

