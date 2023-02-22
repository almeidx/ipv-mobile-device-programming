#!/bin/bash

path=fichas/ficha-0$1/main

kotlinc $path.kt -include-runtime -d $path.jar
java -jar $path.jar
