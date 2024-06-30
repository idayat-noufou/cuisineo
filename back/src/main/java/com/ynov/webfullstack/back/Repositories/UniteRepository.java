package com.ynov.webfullstack.back.Repositories;

import com.ynov.webfullstack.back.Models.Unite;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface UniteRepository extends JpaRepository<Unite, Long> {

}