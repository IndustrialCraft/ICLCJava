package com.github.industrialcraft.ICLCJava.parsetree;

import com.github.industrialcraft.ICLCJava.antlr.IclParser;
import com.github.industrialcraft.ICLCJava.parsetree.instructions.Instruction;

import java.util.ArrayList;


public class Frame {
    Instruction instructions[];
    public Frame(IclParser.FrameContext ctx){
        ArrayList<Instruction> instr = new ArrayList<>();
        for(IclParser.InstructionContext inst : ctx.instruction()){
            instr.add(Instruction.read(inst));
        }
        this.instructions = instr.toArray(Instruction[]::new);
    }
    public Frame(IclParser.FrameOrInstContext ctx){
        if(ctx.instruction() == null) {
            ArrayList<Instruction> instr = new ArrayList<>();
            for(IclParser.InstructionContext inst : ctx.frame().instruction()){
                instr.add(Instruction.read(inst));
            }
            this.instructions = instr.toArray(Instruction[]::new);
        } else {
            this.instructions = new Instruction[]{Instruction.read(ctx.instruction())};
        }
    }
    public Frame(Instruction[] instructions) {
        this.instructions = instructions;
    }
    public Frame(Instruction instruction) {
        this.instructions = new Instruction[]{instruction};
    }
}
