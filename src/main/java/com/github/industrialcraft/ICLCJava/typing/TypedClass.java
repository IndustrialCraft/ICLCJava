package com.github.industrialcraft.ICLCJava.typing;

import com.github.industrialcraft.ICLCJava.Compiler;
import com.github.industrialcraft.ICLCJava.parsetree.SourceFileTree;

import java.util.ArrayList;
import java.util.List;

public class TypedClass {
    String name;
    String classPackage;
    SourceFileTree tree;
    List<TypedMethod> methods;
    List<TypedVariable> variables;
    public TypedClass(String name, String classPackage, List<TypedMethod> methods, List<TypedVariable> variables) {
        this.name = name;
        this.classPackage = classPackage;
        this.tree = null;
        this.methods = methods;
        this.variables = variables;
    }
    public TypedClass(String name, SourceFileTree tree) {
        this.name = name;
        this.classPackage = tree.getPackageName();
        this.tree = tree;
    }
    public void parseMembers(ImportList imports, Compiler compiler){
        if(tree == null)
            return;
        this.methods = tree.getClassMethods().stream().map(method -> new TypedMethod(method, imports, compiler)).toList();
        this.variables = tree.getClassVariables().stream().map(method -> new TypedVariable(method, compiler, imports)).toList();
    }
    public ImportList obtainImports(Compiler compiler){
        if(tree == null)
            return new ImportList(compiler);
        return new ImportList(tree.getImports().stream().map(parseImport -> parseImport.getImportStr()).toList(), compiler);
    }
    public String getFullName(){
        return classPackage + (classPackage.isEmpty()?"":"::") + name;
    }
}
