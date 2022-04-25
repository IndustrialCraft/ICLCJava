package com.github.industrialcraft.ICLCJava.typing;

public class InternalNameAssigner {
    private int typeID;
    private int classID;
    private int methodID;
    private int variableID;
    public InternalNameAssigner() {
        this.typeID = 0;
        this.classID = 0;
        this.methodID = 0;
        this.variableID = 0;
    }
    public int getNextTypeID(){
        return typeID++;
    }
    public int getNextClassID(){
        return classID++;
    }
    public int getNextMethodID(){
        return methodID++;
    }
    public int getNextVariableID(){
        return variableID++;
    }
}
