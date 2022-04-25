package com.github.industrialcraft.ICLCJava.util;

import java.util.regex.Pattern;

public class NameUtil {
    private static Pattern camelCase = Pattern.compile("[a-z]+((\\d)|([A-Z0-9][a-z0-9]+))*([A-Z])?");
    private static Pattern pascalCase = Pattern.compile("([A-Z][a-z0-9]+)((\\d)|([A-Z0-9][a-z0-9]+))*([A-Z])?");
    public static boolean isCamelCase(String str){
        return camelCase.matcher(str).matches();
    }
    public static boolean isPascalCase(String str){
        return pascalCase.matcher(str).matches();
    }

}
