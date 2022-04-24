#!/bin/bash -i
rm build -r
mkdir build
cd build
cp ../Icl.g4 .
antlr4 Icl.g4 -no-listener
rm ../../java/com/github/industrialcraft/ICLCJava/antlr/IclLexer.java
rm ../../java/com/github/industrialcraft/ICLCJava/antlr/IclParser.java
cp IclLexer.java ../../java/com/github/industrialcraft/ICLCJava/antlr
cp IclParser.java ../../java/com/github/industrialcraft/ICLCJava/antlr
