package com.Java8.LambdaExpression;

import java.io.File;
import java.io.FileFilter;

public class FileFilterExample {
    FileFilter fileFilter = new FileFilter() {
        @Override
        public boolean accept(File pathname) {
            return pathname.getName().endsWith(".java");
        }
    };

    FileFilter fileFilterLambda = (File pathname) -> pathname.getName().endsWith(".java");

    public File[] getJavaFiles(String path) {
        File dir = new File(path);
        System.out.println("Filtering files using File Filter Anonymous Function");
        File[] javaFiles = dir.listFiles(fileFilter);
        return javaFiles;
    }

    public File[] getJavaFilesLambda(String path) {
        File dir = new File(path);
        System.out.println("Filtering files using File Filter Lambda Expression");
        File[] javaFiles = dir.listFiles(fileFilterLambda);
        return javaFiles;
    }
}
