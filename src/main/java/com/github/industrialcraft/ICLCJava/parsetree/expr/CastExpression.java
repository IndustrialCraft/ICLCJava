package com.github.industrialcraft.ICLCJava.parsetree.expr;

import com.github.industrialcraft.ICLCJava.antlr.IclParser;

public class CastExpression extends Expression{
    Expression toCast;
    boolean dynamic;
    String type;
    String outputVar;
    public CastExpression(IclParser.CastContext ctx) {
        toCast = Expression.read(ctx.expr());
        dynamic = ctx.DYNCAST() != null;
        type = ctx.NAME(0).getText();
        outputVar = ctx.NAME().size()<=1?null:ctx.NAME(1).getText();
    }
}
