package com.github.industrialcraft.ICLCJava.parsetree.expr;

import com.github.industrialcraft.ICLCJava.antlr.IclParser;

public class CompareExpression extends Expression{
    Expression expr1;
    Expression expr2;
    ECompare compare;
    public CompareExpression(IclParser.CompareExprContext ctx) {
        expr1 = Expression.read(ctx.expr(0));
        expr2 = Expression.read(ctx.expr(1));
        compare = ECompare.read(ctx.compare());
    }
}
