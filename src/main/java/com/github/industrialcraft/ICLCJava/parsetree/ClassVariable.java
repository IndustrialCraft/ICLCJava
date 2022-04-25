package com.github.industrialcraft.ICLCJava.parsetree;

import com.github.industrialcraft.ICLCJava.antlr.IclParser;

public class ClassVariable {
    VarType type;
    String name;
    EVisibility visibility;
    boolean staticVar;
    boolean mutable;
    public ClassVariable(IclParser.Variable_Context ctx) {
        this.name = ctx.NAME().getText();
        this.type = new VarType(ctx.type());
        this.staticVar = ctx.KW_STATIC() != null;
        this.mutable = ctx.HASH() != null;
        this.visibility = EVisibility.fromCTX(ctx.visibility());
    }
    public VarType getType() {
        return type;
    }
    public String getName() {
        return name;
    }
    public EVisibility getVisibility() {
        return visibility;
    }
    public boolean isStaticVar() {
        return staticVar;
    }
    public boolean isMutable() {
        return mutable;
    }
}
