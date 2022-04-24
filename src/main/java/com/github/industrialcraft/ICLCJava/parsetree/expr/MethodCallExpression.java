package com.github.industrialcraft.ICLCJava.parsetree.expr;

import com.github.industrialcraft.ICLCJava.antlr.IclParser;

public class MethodCallExpression extends Expression{
    String name;
    Expression args[];
    public MethodCallExpression(IclParser.MethodCallContext ctx) {
        this.name = ctx.NAME().getText();
        this.args = ctx.expr().stream().map(Expression::read).toArray(Expression[]::new);
    }
}
