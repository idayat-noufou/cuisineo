package com.ynov.webfullstack.back.Repositories;

import com.ynov.webfullstack.back.Models.Instruction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface InstructionRepository extends JpaRepository<Instruction, UUID> {

}