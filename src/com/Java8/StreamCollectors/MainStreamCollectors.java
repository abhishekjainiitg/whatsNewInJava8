package com.Java8.StreamCollectors;

public class MainStreamCollectors {
    public void execute() {
        System.out.println("*********************************************************************************************");
        // Filter and print a stream using chaining as well
        BasicStreamOperations basicStreamOperations = new BasicStreamOperations();
        basicStreamOperations.execute();

        System.out.println("*********************************************************************************************");
        // An example of Map and FlatMap
        FlatMapExample flatMapExample = new FlatMapExample();
        flatMapExample.execute();

        System.out.println("*********************************************************************************************");
        // Reductional And Optional
        ReductionAndOptional reductionAndOptional = new ReductionAndOptional();
        reductionAndOptional.execute();

        System.out.println("*********************************************************************************************");
        // Collectors Example
        CollectorsExample collectorsExample = new CollectorsExample();
        collectorsExample.execute();
    }
}
