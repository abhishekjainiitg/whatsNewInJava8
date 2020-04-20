package com.Java8.DataAndTime;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LocalDatePeriodExample {
    public void execute() {
        System.out.println("Data And Time Example");

        String fileName = "D:\\Programming\\Java\\4WhatsNewInJava8\\src\\com\\Java8\\DataAndTime\\people.txt";
        List<Person> persons = new ArrayList<>();

        System.out.println("Processing the file and listing all the person with DOB");

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream
                    .map(person -> {
                        String[] aPerson = person.split(" ");

                        String firstName = aPerson[0].trim();
                        Integer year = Integer.parseInt(aPerson[1]);
                        Month month = Month.of(Integer.parseInt(aPerson[2]));
                        Integer day = Integer.parseInt(aPerson[3]);

                        Person p = new Person(firstName, LocalDate.of(year, month, day));
                        persons.add(p);
                        return p;
                    })
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("");
        System.out.println("*********************************************************************************************");
        System.out.println("Computing the age of all the persons is years and only months");

        persons.stream()
                .forEach(person -> {
                    LocalDate now = LocalDate.now();
                    Period p = Period.between(person.getDob(), now);

                    long pMonth = person.getDob().until(now, ChronoUnit.MONTHS);

                    System.out.println("Person " + person.getFirstName() + " was born " + p.getYears() + " years and " +
                            p.getMonths() + " months and " + p.getDays() + " [ " + pMonth + " ]");
                });
    }
}
