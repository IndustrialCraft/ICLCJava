package com.github.industrialcraft.ICLCJava.parsetree;

import com.github.industrialcraft.ICLCJava.antlr.IclParser;

public class VarType {
    String type;
    boolean nullable;
    boolean ref;
    boolean refMutable;
    public VarType(IclParser.TypeContext ctx) {
        this.type = ctx.NAME().getText();
        this.nullable = ctx.NULL() != null;
        if(ctx.AND() != null){
            this.ref = true;
            this.refMutable = ctx.HASH() != null;
        }
    }
    public String getType() {
        return type;
    }
    public boolean isNullable() {
        return nullable;
    }
    public boolean isRef() {
        return ref;
    }
    public boolean isRefMutable() {
        return refMutable;
    }
}
