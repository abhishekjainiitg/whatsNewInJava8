package com.Java8.LambdaExpression;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class LambdaExpressionMain {
    public void execute() {
        // Filtering java files without lambda expression
        FileFilterExample fileFilterExample = new FileFilterExample();
        File[] javaFiles = fileFilterExample.getJavaFiles("D:\\Programming\\Java\\3JavaInteractiveCourses\\twitterDataAnalyzer\\src\\com\\twitter\\hasgtag");

        for(File file : javaFiles) {
            System.out.println(file.getName());
        }

        System.out.println("*********************************************************************************************");

        // Filtering java files without lambda expression
        File[] javaFilesLambda = fileFilterExample.getJavaFilesLambda("D:\\Programming\\Java\\3JavaInteractiveCourses\\twitterDataAnalyzer\\src\\com\\twitter\\hasgtag");

        for(File file : javaFilesLambda) {
            System.out.println(file.getName());
        }

        System.out.println("*********************************************************************************************");
        // Sorting Java Lists using Anonymous class implementation of Comparator
        ComparatorExample comparatorExample = new ComparatorExample();
        List<String> list = Arrays.asList("***", "*", "****", "**", "******", "*****", "***");

        comparatorExample.getSortedList(list);

        System.out.println(list);

        System.out.println("*********************************************************************************************");
        // Sorting Java Lists using Lambda Expression implementation of Comparator
        comparatorExample.getSortedListLambda(list);

        System.out.println(list);

        System.out.println("*********************************************************************************************");

        // Chaining of Consumers
        ChainConsumer chainConsumer = new ChainConsumer();
        chainConsumer.execute();
    }
}
