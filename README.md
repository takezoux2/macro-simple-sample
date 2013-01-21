# What is this?

This is simple macro sample.


# How to run sample

First install sbt.(I checked by sbt 0.12.1)
Then type below command.

    > sbt run
    
There will be printed

    age = 23
    nickname = Bob
    
    
# Project structure

Macro is defined at $project_dir$/macrodef/src/main/scala/MacroDef.scala
Macro can't use inside same binary.So this program is separated to macrodef project and root project.