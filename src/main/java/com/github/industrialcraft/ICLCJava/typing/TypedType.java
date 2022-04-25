package com.github.industrialcraft.ICLCJava.typing;

import com.github.industrialcraft.ICLCJava.Compiler;
import com.github.industrialcraft.ICLCJava.parsetree.VarType;

public class TypedType {
    TypedClass clazz;
    boolean nullable;
    boolean reference;
    boolean referenceMutable;

    int internalName;
    public TypedType(Compiler compiler, ImportList imports, VarType type) {
        this.clazz = imports.resolveClassOrException(compiler, type.getType());
        this.nullable = type.isNullable();
        this.reference = type.isRef();
        this.referenceMutable = type.isRefMutable();

        this.internalName = compiler.getInternalNameAssigner().getNextTypeID();
    }
    public TypedClass getClazz() {
        return clazz;
    }
    public boolean isNullable() {
        return nullable;
    }
    public boolean isReference() {
        return reference;
    }
    public boolean isReferenceMutable() {
        return referenceMutable;
    }

    public int internalName(){
        return internalName;
    }
}
