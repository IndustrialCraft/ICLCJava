package com.github.industrialcraft.ICLCJava.parsetree.expr;

import com.github.industrialcraft.ICLCJava.antlr.IclParser;

public class AccessMethodExpression extends Expression{
    Expression expression;
    boolean arrow;
    boolean copy;
    Nullcheck nullcheck;
    String name;
    Expression args[];
    public AccessMethodExpression(IclParser.AccessMethodContext ctx) {
        expression = Expression.read(ctx.expr(0));
        arrow = ctx.ARROW() != null;
        copy = ctx.HASH() != null;
        nullcheck = ctx.nullcheck()==null?null:new Nullcheck(ctx.nullcheck());
        name = ctx.NAME().getText();
        args = ctx.expr().stream().skip(1).map(Expression::read).toArray(Expression[]::new);
    }
}
