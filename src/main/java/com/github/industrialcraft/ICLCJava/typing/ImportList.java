package com.github.industrialcraft.ICLCJava.typing;

import com.github.industrialcraft.ICLCJava.Compiler;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class ImportList {
    List<String> imports;
    public ImportList(List<String> imports, Compiler compiler) {
        this.imports = imports;
        for(int i = 0;i < imports.size();i++){
            for(int j = 0;j < imports.size();j++){
                if(i == j)
                    continue;
                if(lastImportPart(imports.get(i)).equals(lastImportPart(imports.get(j)))){
                    throw new RuntimeException("import ambiguity: two or more imports importing " + lastImportPart(imports.get(i)));
                }
            }
        }
        for(String imp : imports){
            if(compiler.byFullName(imp) == null)
                throw new RuntimeException("import not found: " + imp);
        }
    }
    public ImportList(Compiler compiler, String... imports){
        this(Arrays.asList(imports), compiler);
    }

    TypedClass resolveClass(Compiler compiler, String name){
        TypedClass clz = compiler.byFullName(name);
        if(clz != null)
            return clz;
        for(String imp : imports){
            if(lastImportPart(imp).equals(name))
                return compiler.byFullName(imp);
        }
        return null;
    }
    TypedClass resolveClassOrException(Compiler compiler, String name){
        TypedClass clazz = resolveClass(compiler, name);
        if(clazz == null)
            throw new RuntimeException("couldnt resolve class: " + name);
        return clazz;
    }
    private static String lastImportPart(String importStr){
        String[] split = importStr.split(Pattern.quote("::"));
        return split[split.length-1];
    }
}
