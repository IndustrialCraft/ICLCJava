package com.github.industrialcraft.ICLCJava.parsetree.instructions;

import com.github.industrialcraft.ICLCJava.antlr.IclParser;

public class Instruction {
    public static Instruction read(IclParser.InstructionContext ctx){
        if(ctx.assignExprInstruction() != null)
            return new AssignExprInstruction(ctx.assignExprInstruction());
        if(ctx.breakInstruction() != null)
            return new BreakInstruction(ctx.breakInstruction());
        if(ctx.continueInstruction() != null)
            return new ContinueInstruction(ctx.continueInstruction());
        if(ctx.exprInstruction() != null)
            return new ExprInstruction(ctx.exprInstruction());
        if(ctx.forInstruction() != null)
            return new ForInstruction(ctx.forInstruction());
        if(ctx.ifInstruction() != null)
            return new IfInstruction(ctx.ifInstruction());
        if(ctx.returnInstruction() != null)
            return new ReturnInstruction(ctx.returnInstruction());
        if(ctx.whileInstruction() != null)
            return new WhileInstruction(ctx.whileInstruction());
        throw new RuntimeException("logic error");
    }
}
