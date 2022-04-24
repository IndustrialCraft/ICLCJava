package com.github.industrialcraft.ICLCJava.parsetree.expr;

import com.github.industrialcraft.ICLCJava.antlr.IclParser;

public class NameExpression extends Expression{
    String name;
    public NameExpression(IclParser.NameExprContext ctx) {
        this.name = ctx.NAME().getText();
    }
}
