package com.github.industrialcraft.ICLCJava.parsetree.expr;

import com.github.industrialcraft.ICLCJava.antlr.IclParser;

public class NotExpression extends Expression{
    Expression expr;
    public NotExpression(IclParser.NotExprContext ctx) {
        this.expr = Expression.read(ctx.expr());
    }
}
