package com.github.industrialcraft.ICLCJava.parsetree;

import com.github.industrialcraft.ICLCJava.antlr.IclParser;

import java.util.ArrayList;

public class SourceFileTree {
    String packageName;
    ArrayList<Modificator> classModificators;
    ArrayList<ClassVariable> classVariables;
    ArrayList<ClassMethod> classMethods;
    public SourceFileTree(IclParser.SourceFileContext context){
        this.classModificators = new ArrayList<>();
        this.classVariables = new ArrayList<>();
        this.classMethods = new ArrayList<>();

        this.packageName = context.package_().name_dcol().getText();

        for(IclParser.ModificatorClass_Context ctx: context.modificatorClass_()){
            classModificators.add(new Modificator(ctx.NAME().getText(), ctx.nameArgs().NAME().stream().map(terminalNode -> terminalNode.getText()).toArray(String[]::new)));
        }
        for(IclParser.Variable_Context ctx: context.variable_()){
            classVariables.add(new ClassVariable(ctx));
        }
        for(IclParser.Method_Context ctx: context.method_()){
            classMethods.add(new ClassMethod(ctx));
        }
    }
    public String getPackageName() {
        return packageName;
    }
}
