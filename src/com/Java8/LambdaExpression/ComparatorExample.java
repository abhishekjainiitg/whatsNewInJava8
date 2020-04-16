package com.Java8.LambdaExpression;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample {

    Comparator<String> comp = new Comparator<String>() {
        @Override
        public int compare(String str1, String str2) {
            return Integer.compare(str1.length(), str2.length());
        }
    };

    Comparator<String> compLambda = (String str1, String str2) -> Integer.compare(str1.length(), str2.length());

    public void getSortedList(List<String> list) {
        System.out.println("Sorting list using Anonymous implementation of Comparator");
        Collections.sort(list, comp);
    }

    public void getSortedListLambda(List<String> list) {
        System.out.println("Sorting list using Lambda Expression implementation of Comparator");
        Collections.sort(list, compLambda);
    }
}
