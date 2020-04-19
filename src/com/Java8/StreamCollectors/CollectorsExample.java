package com.Java8.StreamCollectors;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class CollectorsExample {
    // youngest person older than 20, eldest person, map of age to persons, add count as the downstream collector,
    // list of names instead of persons, sort the names, names as string separated by , ,

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


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getYoungestPersonOlderThan20(List<Person> persons) {
        Predicate<Person> olderThan20Person = person -> person.getAge() > 20;

        Optional<Person> person = persons.stream()
                .filter(olderThan20Person)
                .min(Comparator.comparing(Person::getAge));

        return getPersonAsString(person.orElse(Person.GetDefaultPerson()));
    }

    private String getEldestPerson(List<Person> persons) {
        Optional<Person> eldestPerson = persons.stream()
                .max(Comparator.comparing(Person::getAge));

        return getPersonAsString(eldestPerson.orElse(Person.GetDefaultPerson()));
    }

    private String getPersonAsString(Person person) {
        return Person.IsDefaultPerson(person) ? "DNE" : person.toString();
    }
}
