package com.github.industrialcraft.ICLCJava.parsetree;

import com.github.industrialcraft.ICLCJava.antlr.IclParser;

public enum EVisibility {
    PUBLIC,
    PROTECTED,
    PRIVATE;
    public static EVisibility fromCTX(IclParser.VisibilityContext ctx){
        if(ctx == null)
            return null;
        if(ctx.KW_PRIVATE() != null)
            return PRIVATE;
        if(ctx.KW_PROTECTED() != null)
            return PROTECTED;
        if(ctx.KW_PUBLIC() != null)
            return PUBLIC;
        return null;
    }
}
