package com.github.industrialcraft.ICLCJava.parsetree.instructions;

import com.github.industrialcraft.ICLCJava.antlr.IclParser;
import com.github.industrialcraft.ICLCJava.parsetree.Frame;
import com.github.industrialcraft.ICLCJava.parsetree.expr.Expression;

public class IfInstruction extends Instruction{
    Expression expression;
    Frame frame;
    Frame frameElse;
    public IfInstruction(IclParser.IfInstructionContext ctx) {
        this.expression = Expression.read(ctx.expr());
        this.frame = new Frame(ctx.frameOrInst(0));
        this.frameElse = ctx.frameOrInst().size()<=1?null:new Frame(ctx.frameOrInst(1));
    }
    public IfInstruction(Expression expression, Frame frame, Frame frameElse) {
        this.expression = expression;
        this.frame = frame;
        this.frameElse = frameElse;
    }
}
