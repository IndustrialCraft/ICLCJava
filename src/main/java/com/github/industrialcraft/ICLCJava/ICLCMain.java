package com.github.industrialcraft.ICLCJava;

import com.github.industrialcraft.ICLCJava.antlr.IclLexer;
import com.github.industrialcraft.ICLCJava.antlr.IclParser;
import com.github.industrialcraft.ICLCJava.parsetree.SourceFileTree;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.File;

public class ICLCMain {
    public static void main(String args[]){
        Compiler compiler = new Compiler();
        compiler.addSource(new File("Main.icl"));
        System.out.println(compiler);
    }
}
