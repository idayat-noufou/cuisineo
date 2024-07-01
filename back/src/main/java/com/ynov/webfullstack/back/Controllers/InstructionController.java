package com.ynov.webfullstack.back.Controllers;

import com.ynov.webfullstack.back.Models.Instruction;
import com.ynov.webfullstack.back.Models.Recette;
import com.ynov.webfullstack.back.Service.InstructionService;
import com.ynov.webfullstack.back.Service.RecetteService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class InstructionController {

    @Autowired
    private InstructionService instructionService;

    @GetMapping("/instructions/{id}")
    public Optional<Instruction> getInstruction(long id){
        return instructionService.getInstruction(id);
    }

    @GetMapping("/instructions")
    public Iterable<Instruction> getInstructions() {
        return instructionService.getInstructions();
    }

    @PostMapping("/instruction/{instruction}")
    public void saveInstruction(Instruction instruction){
        instructionService.saveInstruction(instruction);
    }

    @PostMapping("/instruction/{id}")
    public void deleteInstruction(long id){
        instructionService.deleteInstruction(id);
    }
}