package com.github.industrialcraft.ICLCJava.parsetree.instructions;

import com.github.industrialcraft.ICLCJava.antlr.IclParser;
import com.github.industrialcraft.ICLCJava.parsetree.VarType;
import com.github.industrialcraft.ICLCJava.parsetree.expr.Expression;

public class AssignExprInstruction extends Instruction{
    VarType type;
    String name;
    Expression expression;
    public AssignExprInstruction(IclParser.AssignExprInstructionContext ctx) {
        this.type = ctx.type()==null?null:new VarType(ctx.type());
        this.name = ctx.NAME().getText();
        this.expression = ctx.expr()==null?null:Expression.read(ctx.expr());
    }
    public AssignExprInstruction(VarType type, String name, Expression expression) {
        this.type = type;
        this.name = name;
        this.expression = expression;
    }
}
