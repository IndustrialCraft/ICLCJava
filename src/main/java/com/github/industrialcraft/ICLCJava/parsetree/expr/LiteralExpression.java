package com.github.industrialcraft.ICLCJava.parsetree.expr;

import com.github.industrialcraft.ICLCJava.antlr.IclParser;

public class LiteralExpression extends Expression{
    String literal;
    public LiteralExpression(IclParser.LiteralExprContext ctx) {
        this.literal = ctx.literal().getText();
    }
}
