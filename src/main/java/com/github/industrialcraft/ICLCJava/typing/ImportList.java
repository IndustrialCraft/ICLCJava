package com.github.industrialcraft.ICLCJava.typing;

import com.github.industrialcraft.ICLCJava.Compiler;

import java.util.Arrays;
import java.util.List;

public class ImportList {
    List<String> imports;
    public ImportList(List<String> imports) {
        this.imports = imports;
    }
    public ImportList(String... imports){
        this.imports = Arrays.asList(imports);
    }

    TypedClass resolveClass(Compiler compiler, String name){
        TypedClass clz = compiler.byFullName(name);
        if(clz != null)
            return clz;



        return clz;
    }
    TypedClass resolveClassOrException(Compiler compiler, String name){
        TypedClass clazz = resolveClass(compiler, name);
        if(clazz == null)
            throw new RuntimeException("couldnt resolve class: " + name);
        return clazz;
    }
}
