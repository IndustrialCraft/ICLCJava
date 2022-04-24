package com.github.industrialcraft.ICLCJava.parsetree.expr;

import com.github.industrialcraft.ICLCJava.antlr.IclParser;

public class CopyExpression extends Expression{
    Expression expression;
    boolean mutableCopy;
    public CopyExpression(IclParser.CopyExprContext ctx){
        expression = Expression.read(ctx.expr());
        mutableCopy = ctx.HASH().size() > 1;
    }
}
