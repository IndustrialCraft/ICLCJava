package com.github.industrialcraft.ICLCJava.parsetree.expr;

import com.github.industrialcraft.ICLCJava.antlr.IclParser;

public class AccessArrayExpression extends Expression{
    Expression array;
    Expression index;
    public AccessArrayExpression(IclParser.AccessArrayContext ctx) {
        this.array = Expression.read(ctx.expr(0));
        this.index = Expression.read(ctx.expr(1));
    }
}
