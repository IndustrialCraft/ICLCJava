package com.github.industrialcraft.ICLCJava.parsetree.expr;

import com.github.industrialcraft.ICLCJava.antlr.IclParser;

public class OperatorExpression extends Expression{
    Expression expr1;
    Expression expr2;
    EOperator operator;
    public OperatorExpression(IclParser.OperatorExprContext ctx) {
        expr1 = Expression.read(ctx.expr(0));
        expr2 = Expression.read(ctx.expr(1));
        operator = EOperator.read(ctx.operator());
    }
}
