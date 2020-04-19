package com.Java8.StreamCollectors;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsExample {

    public void execute() {
        System.out.println("Collectors Example");

        String fileName = "D:\\Programming\\Java\\4WhatsNewInJava8\\src\\com\\Java8\\StreamCollectors\\people.txt";
        List<Person> persons = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream
                    .map(person -> {
                        String[] aPerson = person.split(" ");
                        Person p = new Person(aPerson[0].trim(), "Jain", Integer.parseInt(aPerson[1]));
                        persons.add(p);
                        return p;
                    })
                    .forEach(System.out::println);

            System.out.println("");
            System.out.println("*********************************************************************************************");
            String youngestPersonOlderThan20 = getYoungestPersonOlderThan20(persons) ;
            System.out.println("The youngest person older than 20 is : " + youngestPersonOlderThan20);

            System.out.println("");
            System.out.println("*********************************************************************************************");
            String eldestPerson = getEldestPerson(persons) ;
            System.out.println("The eldest person is : " + eldestPerson);

            System.out.println("");
            System.out.println("*********************************************************************************************");
            Map<Integer, Long> ageToPersonMap = getAgeToPersonMap(persons) ;
            System.out.println("Map of age to person-count is : " + ageToPersonMap);

            System.out.println("");
            System.out.println("*********************************************************************************************");
            Map<Integer, List<String>> ageToPersonLastNameAsListMap = getAgeToPersonLastNameAsListMap(persons) ;
            System.out.println("Map of age to person-firstName is : " + ageToPersonLastNameAsListMap);

            System.out.println("");
            System.out.println("*********************************************************************************************");
            Map<Integer, TreeSet<String>> ageToPersonLastNameAsTreeSet = getAgeToPersonLastNameAsTreeSet(persons) ;
            System.out.println("Map of age to person-firstName as treeset for sorting is : " + ageToPersonLastNameAsTreeSet);

            System.out.println("");
            System.out.println("*********************************************************************************************");
            Map<Integer, String> ageToPersonLastNameAsCommaSeparatedString = getAgeToPersonLastNameAsCommaSeparatedString(persons) ;
            System.out.println("Map of age to person-firstName as Comma Separate String is : " + ageToPersonLastNameAsCommaSeparatedString);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getYoungestPersonOlderThan20(@NotNull List<Person> persons) {
        Predicate<Person> olderThan20Person = person -> person.getAge() > 20;

        Optional<Person> person = persons.stream()
                .filter(olderThan20Person)
                .min(Comparator.comparing(Person::getAge));

        return getPersonAsString(person.orElse(Person.GetDefaultPerson()));
    }

    private String getEldestPerson(@NotNull List<Person> persons) {
        Optional<Person> eldestPerson = persons.stream()
                .max(Comparator.comparing(Person::getAge));

        return getPersonAsString(eldestPerson.orElse(Person.GetDefaultPerson()));
    }

    private Map<Integer, Long> getAgeToPersonMap(@NotNull List<Person> persons) {
        return persons.stream()
                .collect(
                        Collectors.groupingBy(
                                Person::getAge,
                                Collectors.counting()
                        )
                );
    }

    private Map<Integer, List<String>> getAgeToPersonLastNameAsListMap(@NotNull List<Person> persons) {
        return persons.stream()
                .collect(
                        Collectors.groupingBy(
                                Person::getAge,
                                Collectors.mapping(
                                        Person::getFirstName,
                                        Collectors.toList()
                                )
                        )
                );
    }

    private Map<Integer, TreeSet<String>> getAgeToPersonLastNameAsTreeSet(@NotNull List<Person> persons) {
        return persons.stream()
                .collect(
                        Collectors.groupingBy(
                                Person::getAge,
                                Collectors.mapping(
                                        Person::getFirstName,
                                        Collectors.toCollection(TreeSet::new)
                                )
                        )
                );
    }

    private Map<Integer, String> getAgeToPersonLastNameAsCommaSeparatedString(@NotNull List<Person> persons) {
        return persons.stream()
                .collect(
                        Collectors.groupingBy(
                                Person::getAge,
                                Collectors.mapping(
                                        Person::getFirstName,
                                        Collectors.joining(", ")
                                )
                        )
                );
    }

    private String getPersonAsString(Person person) {
        return Person.IsDefaultPerson(person) ? "DNE" : person.toString();
    }
}
