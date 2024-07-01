package com.ynov.webfullstack.back.Repositories;

import com.ynov.webfullstack.back.Models.Composition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CompositionRepository extends JpaRepository<Composition, UUID> {

}