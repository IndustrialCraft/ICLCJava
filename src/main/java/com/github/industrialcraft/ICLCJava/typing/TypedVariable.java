package com.github.industrialcraft.ICLCJava.typing;

import com.github.industrialcraft.ICLCJava.Compiler;
import com.github.industrialcraft.ICLCJava.parsetree.ClassMethod;
import com.github.industrialcraft.ICLCJava.parsetree.ClassVariable;
import com.github.industrialcraft.ICLCJava.parsetree.EVisibility;

public class TypedVariable {
    TypedType type;
    String name;
    boolean isStatic;
    boolean mutable;
    EVisibility visibility;
    ClassVariable ast;
    public TypedVariable(ClassVariable var, Compiler compiler, ImportList imports) {
        this.ast = var;
        this.type = new TypedType(compiler, imports, var.getType());
        this.name = var.getName();
        this.isStatic = var.isStaticVar();
        this.mutable = var.isMutable();
        this.visibility = var.getVisibility();
    }

}
