package com.github.industrialcraft.ICLCJava;

import com.github.industrialcraft.ICLCJava.antlr.IclLexer;
import com.github.industrialcraft.ICLCJava.antlr.IclParser;
import com.github.industrialcraft.ICLCJava.parsetree.SourceFileTree;
import com.github.industrialcraft.ICLCJava.typing.TypedClass;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.File;
import java.util.Collections;

public class ICLCMain {
    public static void main(String args[]){
        Compiler compiler = new Compiler();
        compiler.addClass(new TypedClass("void", "", Collections.emptyList(), Collections.emptyList()));
        compiler.addClass(new TypedClass("int", "", Collections.emptyList(), Collections.emptyList()));
        compiler.addClass(new TypedClass("bool", "", Collections.emptyList(), Collections.emptyList()));

        compiler.addSource(new File("Main.icl"));

        compiler.make();
        System.out.println(compiler);
    }
}
