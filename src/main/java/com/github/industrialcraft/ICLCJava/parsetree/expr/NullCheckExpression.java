package com.github.industrialcraft.ICLCJava.parsetree.expr;

import com.github.industrialcraft.ICLCJava.antlr.IclParser;

public class NullCheckExpression extends Expression{
    Expression expression;
    Nullcheck nullcheck;
    public NullCheckExpression(IclParser.NullcheckExprContext ctx) {
        expression = Expression.read(ctx.expr());
        nullcheck = new Nullcheck(ctx.nullcheck());
    }
}
