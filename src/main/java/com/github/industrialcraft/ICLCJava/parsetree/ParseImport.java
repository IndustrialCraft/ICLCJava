package com.github.industrialcraft.ICLCJava.parsetree;

import com.github.industrialcraft.ICLCJava.antlr.IclParser;

public class ParseImport {
    String importStr;
    public ParseImport(IclParser.Import_Context ctx){
        this.importStr = ctx.name_dcol().getText();
    }
    public String getImportStr() {
        return importStr;
    }
}
