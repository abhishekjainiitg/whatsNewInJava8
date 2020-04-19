package com.Java8.StreamCollectors;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class ReductionAndOptional {
    public void execute() {
        // Stream and Optional Example
        System.out.println("Doing Reduction operations on the stream:");
        List<Integer> list = Arrays.asList(1, 20, 13, 44, 25);
        Stream<Integer> stream = list.stream();

        stream.forEach(System.out::println);

        Integer sum = list.stream().reduce(0, Integer::sum);

        System.out.println("*** Sum is " + sum);

        System.out.println("*** Max is: " + getMaxFromStream(list.stream(), 1000));

        System.out.println("*** For an empty stream with default as 1000, Max is: " + getMaxFromStream(Stream.empty(), 1000));

        System.out.println("");
        System.out.println("Checking out allMatch, findFirst etc. using a Person class");

        List<Person> persons = Arrays.asList(
                new Person("Abhishek", "Jain", 27),
                new Person("Aman", "Jain", 26),
                new Person("Akash", "Jain", 33),
                new Person("Isha", "Jain", 36),
                new Person("Yash", "Jain", 30)
        );

        Integer sumOfAge = persons.stream()
                .map(Person::getAge)
                .reduce(0, Integer::sum);

        Integer numberOfPersons = persons.size();
        Float averageAge = sumOfAge.floatValue()/numberOfPersons.floatValue();

        System.out.println("*** Average of age of all person is:: " + averageAge);

        Boolean areAllJains = persons.stream()
                .map(Person::getLastName)
                .allMatch(Predicate.isEqual("Jain"));

        System.out.println("*** Are all Jains? :: " + areAllJains);

        System.out.println("Finding first Jain with age greater than average");

        Predicate<Person> shouldBeJain = person -> person.getLastName() == "Jain";
        Predicate<Person> shouldHaveAboveAverageAge = person -> person.getAge() > averageAge;

        Predicate<Person> jainWithAboveAvgAge = shouldBeJain.and(shouldHaveAboveAverageAge);

        Optional<Person> optionalJainWithAboveAverageAge = persons.stream()
                .filter(jainWithAboveAvgAge)
                .findFirst();

        Person jainWithAboveAverageAge = optionalJainWithAboveAverageAge.orElse(new Person("NA", "NA", 0));

        String personName = jainWithAboveAverageAge.getFirstName() != "NA" ? jainWithAboveAverageAge.toString() : "Does Not Exist";
        System.out.println("Person with above average is : " + personName);

        long countOfJainWithAboveAverageAge = persons.stream()
                .filter(jainWithAboveAvgAge)
                .count();

        System.out.println("Number of Jains with above average age is :: " + countOfJainWithAboveAverageAge);
    }

    private Integer getMaxFromStream(Stream<Integer> stream, Integer defaultValue) {
        Optional<Integer> max = stream.max(Comparator.naturalOrder());
        return max.orElse(defaultValue);
    }
}
