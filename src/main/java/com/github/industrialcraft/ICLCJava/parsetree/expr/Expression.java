package com.github.industrialcraft.ICLCJava.parsetree.expr;

import com.github.industrialcraft.ICLCJava.antlr.IclParser;

public class Expression {
    public static Expression read(IclParser.ExprContext ctx){
        if(ctx instanceof IclParser.ParanExprContext expr){
            return new ParanExpression(expr);
        }
        if(ctx instanceof IclParser.LiteralExprContext expr){
            return new LiteralExpression(expr);
        }
        if(ctx instanceof IclParser.NameExprContext expr){
            return new NameExpression(expr);
        }
        if(ctx instanceof IclParser.NotExprContext expr){
            return new NotExpression(expr);
        }
        if(ctx instanceof IclParser.OperatorExprContext expr){
            return new OperatorExpression(expr);
        }
        if(ctx instanceof IclParser.CompareExprContext expr){
            return new CompareExpression(expr);
        }
        if(ctx instanceof IclParser.NullcheckExprContext expr){
            return new NullCheckExpression(expr);
        }
        if(ctx instanceof IclParser.CopyExprContext expr){
            return new CopyExpression(expr);
        }
        if(ctx instanceof IclParser.MethodCallContext expr){
            return new MethodCallExpression(expr);
        }
        if(ctx instanceof IclParser.CastContext expr){
            return new CastExpression(expr);
        }
        if(ctx instanceof IclParser.AccessVarContext expr){
            return new AccessVarExpression(expr);
        }
        if(ctx instanceof IclParser.AccessMethodContext expr){
            return new AccessMethodExpression(expr);
        }
        if(ctx instanceof IclParser.AccessArrayContext expr){
            return new AccessArrayExpression(expr);
        }
        return null;
    }
}
