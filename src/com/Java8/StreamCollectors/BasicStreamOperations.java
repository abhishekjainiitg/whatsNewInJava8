package com.Java8.StreamCollectors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class BasicStreamOperations {
    public void execute() {
        List<String> list = Arrays.asList("one", "two", "three", "four", "five");

        Consumer<String> c1 = System.out::println;
        Predicate<String> p1 = value -> value.length() > 3;
        Predicate<String> p2 = Predicate.isEqual("one");

        Stream<String> stream = list.stream();
        List<String> result = new ArrayList<>();

        stream
                .peek(c1)
                .filter(p1.or(p2))
                .forEach(result::add);

        System.out.println("Size of filtered list is " + result.size());
    }
}
