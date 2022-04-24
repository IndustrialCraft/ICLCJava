package com.github.industrialcraft.ICLCJava.parsetree.expr;

import com.github.industrialcraft.ICLCJava.antlr.IclParser;

public class AccessVarExpression extends Expression{
    Expression expression;
    boolean arrow;
    String name;
    public AccessVarExpression(IclParser.AccessVarContext ctx) {
        expression = Expression.read(ctx.expr());
        arrow = ctx.ARROW() != null;
        name = ctx.NAME().getText();
    }
}
