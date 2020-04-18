package com.Java8.StreamCollectors;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class FlatMapExample {
    public void execute() {
        // Map and FlatMap Example
        System.out.println("Example of Map and FlatMap");

        List<Number> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        List<Number> list2 = Arrays.asList(1, 3, 5, 7);
        List<Number> list3 = Arrays.asList(2, 4, 6);

        List<List<Number>> list = Arrays.asList(list1, list2, list3);

        Function<List<Number>, Number> f1 = List::size;

        System.out.println("");
        System.out.println("***Using map on Numbers");
        list.stream()
                .map(f1)
                .forEach(System.out::println);

        System.out.println("");
        System.out.println("***Using map on Stream of Numbers");
        Function<List<Number>, Stream<Number>> f2 = Collection::stream;

        list.stream()
                .map(f2)
                .forEach(System.out::println);

        System.out.println("");
        System.out.println("***Using flatmap on Stream of Numbers");

        list.stream()
                .flatMap(f2)
                .forEach(System.out::println);
    }
}
