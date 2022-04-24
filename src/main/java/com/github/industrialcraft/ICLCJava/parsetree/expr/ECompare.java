package com.github.industrialcraft.ICLCJava.parsetree.expr;

import com.github.industrialcraft.ICLCJava.antlr.IclParser;

public enum ECompare {
    EQEQ,
    NE,
    LT,
    LE,
    GT,
    GE;
    public static ECompare read(IclParser.CompareContext ctx){
        return null;
    }
}
