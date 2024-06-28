package com.ynov.webfullstack.back.repositories;

import com.ynov.webfullstack.back.Models.Composition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompositionRepository extends JpaRepository<Composition, Long> {

}