package com.ynov.webfullstack.back.Repositories;

import com.ynov.webfullstack.back.Models.Unite;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniteRepository extends CrudRepository<Unite, Long> {

}