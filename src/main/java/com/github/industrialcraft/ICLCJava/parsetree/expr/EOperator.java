package com.github.industrialcraft.ICLCJava.parsetree.expr;

import com.github.industrialcraft.ICLCJava.antlr.IclParser;

public enum EOperator {
    PLUS,
    MINUS,
    MULT,
    DIV,
    MOD,
    ORD,
    ANDD,
    OR,
    AND,
    XOR;
    public static EOperator read(IclParser.OperatorContext ctx){
        return null;
    }
}
