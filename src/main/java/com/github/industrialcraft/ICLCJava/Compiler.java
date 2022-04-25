package com.github.industrialcraft.ICLCJava;

import com.github.industrialcraft.ICLCJava.antlr.IclLexer;
import com.github.industrialcraft.ICLCJava.antlr.IclParser;
import com.github.industrialcraft.ICLCJava.parsetree.SourceFileTree;
import com.github.industrialcraft.ICLCJava.typing.InternalNameAssigner;
import com.github.industrialcraft.ICLCJava.typing.TypedClass;
import com.github.industrialcraft.ICLCJava.util.NameUtil;
import com.github.industrialcraft.ICLCJava.util.FileUtil;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.File;
import java.util.HashMap;

public class Compiler {
    private HashMap<String, TypedClass> sources;
    private InternalNameAssigner internalNameAssigner;
    public Compiler(){
        this.sources = new HashMap<>();
    }
    public void addSource(File file){
        String fileContent = FileUtil.read(file);
        IclLexer lexer = new IclLexer(CharStreams.fromString(fileContent));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        IclParser parser = new IclParser(tokens);
        SourceFileTree tree = new SourceFileTree(parser.sourceFile());
        String className = file.getName().replace(".icl","");
        if(!NameUtil.isPascalCase(className))
            System.out.println("[WARN]expected classname " + className + " to be PascalCase");
        TypedClass typedClass = new TypedClass(className, tree, this);
        if(sources.containsKey(typedClass.getFullName()))
            throw new RuntimeException("duplicate definition of class " + typedClass.getFullName());
        if(typedClass.getFullName().contains("_"))
            throw new RuntimeException("nor package name nor class name cannot contain '_', which was the case in " + typedClass.getFullName());
        sources.put(typedClass.getFullName(), typedClass);
    }
    public void addClass(TypedClass typedClass){
        sources.put(typedClass.getFullName(), typedClass);
    }
    public void make(){
        for(TypedClass clazz : sources.values()){
            clazz.parseMembers(clazz.obtainImports(this), this);
        }
        for(TypedClass clazz : sources.values()){
            clazz.parseCode(this, clazz.obtainImports(this));
        }
    }
    public TypedClass byFullName(String fullName){
        return sources.get(fullName);
    }
    public InternalNameAssigner getInternalNameAssigner() {
        return internalNameAssigner;
    }
}
