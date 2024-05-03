package com.ynov.webfullstack.back.Repositories;

import com.ynov.webfullstack.back.Models.Instruction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructionRepository extends CrudRepository<Instruction, Long> {

}