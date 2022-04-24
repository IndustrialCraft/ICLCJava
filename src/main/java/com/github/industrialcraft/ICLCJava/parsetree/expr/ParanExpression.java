package com.github.industrialcraft.ICLCJava.parsetree.expr;

import com.github.industrialcraft.ICLCJava.antlr.IclParser;

public class ParanExpression extends Expression{
    Expression expr;
    public ParanExpression(IclParser.ParanExprContext ctx) {
        this.expr = Expression.read(ctx.expr());
    }
}
