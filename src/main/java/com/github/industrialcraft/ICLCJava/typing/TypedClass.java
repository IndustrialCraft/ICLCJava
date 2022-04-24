package com.github.industrialcraft.ICLCJava.typing;

import com.github.industrialcraft.ICLCJava.parsetree.SourceFileTree;

public class TypedClass {
    String name;
    String classPackage;
    SourceFileTree tree;
    public TypedClass(String name, SourceFileTree tree) {
        this.name = name;
        this.classPackage = tree.getPackageName();
        this.tree = tree;
    }
    public String getFullName(){
        return classPackage + "::" + name;
    }
}
