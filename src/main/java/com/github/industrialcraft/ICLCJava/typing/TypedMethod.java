package com.github.industrialcraft.ICLCJava.typing;

import com.github.industrialcraft.ICLCJava.Compiler;
import com.github.industrialcraft.ICLCJava.parsetree.ClassMethod;
import com.github.industrialcraft.ICLCJava.parsetree.EVisibility;

import java.util.Arrays;

public class TypedMethod {
    TypedType returnType;
    String name;
    Parameter[] parameters;
    ClassMethod ast;
    boolean thisMutable;
    boolean isStatic;
    EVisibility visibility;
    TypedClass parent;

    int internalName;
    public TypedMethod(ClassMethod ast, ImportList importList, Compiler compiler, TypedClass parent) {
        this.parent = parent;
        this.ast = ast;
        this.visibility = ast.getVisibility();
        this.returnType = new TypedType(compiler, importList, ast.getType());
        this.name = ast.getName();
        this.thisMutable = ast.isThisMutable();
        this.isStatic = ast.isStaticMethod();
        this.parameters = Arrays.stream(ast.getParameters()).map(parameter -> parameter.typed(compiler, importList)).toArray(Parameter[]::new);

        this.internalName = compiler.getInternalNameAssigner().getNextMethodID();
    }

    public void compileCode(Compiler compiler, ImportList imports){

    }

    public int internalName(){
        return internalName;
    }

    public static class Parameter{
        TypedType type;
        String name;
        public Parameter(TypedType type, String name) {
            this.type = type;
            this.name = name;
        }
    }
}
