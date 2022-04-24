package com.github.industrialcraft.ICLCJava.parsetree.instructions;

import com.github.industrialcraft.ICLCJava.antlr.IclParser;
import com.github.industrialcraft.ICLCJava.parsetree.expr.Expression;

public class BreakInstruction extends Instruction{
    Expression expression;
    public BreakInstruction(IclParser.BreakInstructionContext ctx) {
        this.expression = ctx.expr() == null?null:Expression.read(ctx.expr());
    }
    public BreakInstruction(Expression expression) {
        this.expression = expression;
    }
}
