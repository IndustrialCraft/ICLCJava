package com.github.industrialcraft.ICLCJava.parsetree.expr;

import com.github.industrialcraft.ICLCJava.antlr.IclParser;

public class Nullcheck {
    Expression defaultExpr;
    public Nullcheck(IclParser.NullcheckContext ctx) {
        if(ctx.expr() != null)
            this.defaultExpr = Expression.read(ctx.expr());
    }
}
