package com.github.industrialcraft.ICLCJava.parsetree;

import com.github.industrialcraft.ICLCJava.Compiler;
import com.github.industrialcraft.ICLCJava.antlr.IclParser;
import com.github.industrialcraft.ICLCJava.typing.ImportList;
import com.github.industrialcraft.ICLCJava.typing.TypedMethod;
import com.github.industrialcraft.ICLCJava.typing.TypedType;

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

    public String getName() {
        return name;
    }
    public boolean isStaticMethod() {
        return staticMethod;
    }
    public boolean isThisMutable() {
        return thisMutable;
    }
    public EVisibility getVisibility() {
        return visibility;
    }
    public VarType getType() {
        return type;
    }
    public Parameter[] getParameters() {
        return parameters;
    }
    public Frame getFrame() {
        return frame;
    }

    public static class Parameter{
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
        public TypedMethod.Parameter typed(Compiler compiler, ImportList imports){
            return new TypedMethod.Parameter(new TypedType(compiler, imports, getType()), getName());
        }
        public VarType getType() {
            return type;
        }
        public String getName() {
            return name;
        }
    }
}
