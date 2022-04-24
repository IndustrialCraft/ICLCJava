package com.github.industrialcraft.ICLCJava;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Collectors;

public class Util {
    public static String read(File file){
        try {
            return Files.lines(file.toPath()).collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
