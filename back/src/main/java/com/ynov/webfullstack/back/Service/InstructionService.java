package com.ynov.webfullstack.back.Service;

import com.ynov.webfullstack.back.Models.Instruction;
import com.ynov.webfullstack.back.Repositories.InstructionRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Data
@Service
public class InstructionService {

    @Autowired
    private InstructionRepository instructionRepository;

    public Optional<Instruction> getInstruction(final UUID id) {
        return instructionRepository.findById(id);
    }

    public Iterable<Instruction> getInstructions() {
        return instructionRepository.findAll();
    }

    public void deleteInstruction(final UUID id) {
        instructionRepository.deleteById(id);
    }

    public Instruction saveInstruction(Instruction instruction) {
        Instruction savedInstruction = instructionRepository.save(instruction);
        return savedInstruction;
    }

}