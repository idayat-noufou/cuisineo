package com.ynov.webfullstack.back.Repositories;

import com.ynov.webfullstack.back.Models.Composition;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompositionRepository extends CrudRepository<Composition, Long> {

}