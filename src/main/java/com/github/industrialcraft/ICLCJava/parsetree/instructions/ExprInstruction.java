package com.github.industrialcraft.ICLCJava.parsetree.instructions;

import com.github.industrialcraft.ICLCJava.antlr.IclParser;
import com.github.industrialcraft.ICLCJava.parsetree.expr.Expression;

public class ExprInstruction extends Instruction{
    Expression expression;
    public ExprInstruction(IclParser.ExprInstructionContext ctx) {
        this.expression = Expression.read(ctx.expr());
    }
    public ExprInstruction(Expression expression) {
        this.expression = expression;
    }
}
