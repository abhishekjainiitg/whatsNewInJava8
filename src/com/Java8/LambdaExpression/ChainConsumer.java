package com.Java8.LambdaExpression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ChainConsumer {

    public void execute() {
        Consumer<String> c1 = System.out::println;

        List<String> list = Arrays.asList(
                "one",
                "two",
                "three",
                "four",
                "five"
        );

        List<String> result = new ArrayList<>();

        Consumer<String> c2 = result::add;

        list.forEach(c1.andThen(c2));

        System.out.println("Size of the result array is " + result.size());
    }
}
