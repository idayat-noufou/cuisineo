package com.ynov.webfullstack.back.Service;

import com.ynov.webfullstack.back.Models.Instruction;
import com.ynov.webfullstack.back.Repositories.InstructionRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class InstructionService {

    @Autowired
    private InstructionRepository instructionRepository;

    public Optional<Instruction> getInstruction(final long id) {
        return instructionRepository.findById(id);
    }

    public Iterable<Instruction> getInstructions() {
        return instructionRepository.findAll();
    }

    public void deleteInstruction(final long id) {
        instructionRepository.deleteById(id);
    }

    public Instruction saveInstruction(Instruction instruction) {
        Instruction savedInstruction = instructionRepository.save(instruction);
        return savedInstruction;
    }

}