package com.Java8.NewAPI;

import com.Java8.StreamCollectors.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapMergeExample {
    public void execute() {
        System.out.println("Map Merge Example");

        String fileName = "D:\\Programming\\Java\\4WhatsNewInJava8\\src\\com\\Java8\\NewAPI\\people.txt";
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

        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Person> list1 = persons.subList(0, 10);
        List<Person> list2 = persons.subList(10, persons.size() - 1);

        Map<Integer, List<Person>> map1 = getAgeTOPersonMap(list1);
        Map<Integer, List<Person>> map2 = getAgeTOPersonMap(list2);

        System.out.println("Map1 is: ");
        map1.forEach((key, value) -> System.out.println(key + " --> " + value));

        System.out.println("Map2 is: ");
        map2.forEach((key, value) -> System.out.println(key + " --> " + value));

        map2.entrySet().stream()
                .forEach(entry -> {
                    map1.merge(
                            entry.getKey(),
                            entry.getValue(),
                            (l1, l2) -> {
                                l1.addAll(l2);
                                return l1;
                            }
                    );
                });

        System.out.println("Merged Map is is: ");
        map1.forEach((key, value) -> System.out.println(key + " --> " + value));
    }

    private Map<Integer, List<Person>> getAgeTOPersonMap(List<Person> list) {
        Map<Integer, List<Person>> map = list.stream()
                .collect(
                        Collectors.groupingBy(
                                Person::getAge
                        )
                );
        return map;
    }
}
