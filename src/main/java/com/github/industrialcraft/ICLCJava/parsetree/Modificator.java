package com.github.industrialcraft.ICLCJava.parsetree;

public class Modificator {
    String name;
    String[] args;
    public Modificator(String name, String... args) {
        this.name = name;
        this.args = args;
    }
    public String getName() {
        return name;
    }
    public String[] getArgs() {
        return args;
    }
}
