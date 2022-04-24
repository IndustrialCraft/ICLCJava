package com.github.industrialcraft.ICLCJava.parsetree;

import com.github.industrialcraft.ICLCJava.antlr.IclParser;

import java.util.ArrayList;

public class ClassMethod {
    String name;
    boolean staticMethod;
    boolean thisMutable;
    EVisibility visibility;
    VarType type;
    Parameter parameters[];
    Frame frame;
    public ClassMethod(IclParser.Method_Context ctx) {
        this.name = ctx.NAME().getText();
        this.staticMethod = ctx.KW_STATIC() != null;
        this.visibility = EVisibility.fromCTX(ctx.visibility());
        this.type = new VarType(ctx.type());
        this.parameters = Parameter.getParameters(ctx.typeNameArgs());
        this.thisMutable = ctx.HASH() != null;
        this.frame = new Frame(ctx.frame());
    }

    static class Parameter{
        VarType type;
        String name;
        public Parameter(VarType type, String name) {
            this.type = type;
            this.name = name;
        }
        public static Parameter[] getParameters(IclParser.TypeNameArgsContext ctx){
            ArrayList<Parameter> parameters = new ArrayList<>();
            int i = 0;
            for(IclParser.TypeContext type : ctx.type()){
                parameters.add(new Parameter(new VarType(type), ctx.NAME(i).getText()));
                i++;
            }

            return parameters.toArray(Parameter[]::new);
        }
    }
}
