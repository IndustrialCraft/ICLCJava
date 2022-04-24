package com.github.industrialcraft.ICLCJava.parsetree.instructions;

import com.github.industrialcraft.ICLCJava.antlr.IclParser;
import com.github.industrialcraft.ICLCJava.parsetree.expr.Expression;

public class ReturnInstruction extends Instruction{
    Expression expression;

    public ReturnInstruction(IclParser.ReturnInstructionContext ctx) {
        this.expression = ctx.expr()==null?null:Expression.read(ctx.expr());
    }

    public ReturnInstruction(Expression expression) {
        this.expression = expression;
    }
}
