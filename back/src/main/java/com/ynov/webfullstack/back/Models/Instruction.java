package com.ynov.webfullstack.back.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "instruction")
public class Instruction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="instr_prec")
    private int instr_prec;

    @Column(name="instr_suiv")
    private int instr_suiv;

    @Column(name="instruction")
    private String instruction;

    public Instruction(String instruction) {
        this.instruction = instruction;
    }

    public Instruction(int instr_prec, String instruction) {
        this.instr_prec = instr_prec;
        this.instruction = instruction;
    }

    public Instruction() {}

    public int getInstr_prec() {
        return instr_prec;
    }

    public int getInstr_suiv() {
        return instr_suiv;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public void setInstr_suiv(int instr_suiv) {
        this.instr_suiv = instr_suiv;
    }

    public void setInstr_prec(int instr_prec) {
        this.instr_prec = instr_prec;
    }
}