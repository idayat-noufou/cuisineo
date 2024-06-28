package com.ynov.webfullstack.back.repositories;

import com.ynov.webfullstack.back.Models.Instruction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructionRepository extends JpaRepository<Instruction, Long> {

}