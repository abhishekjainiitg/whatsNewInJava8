package com.Java8.StreamCollectors;

import java.util.Objects;

public class Person {
    private String firstName;
    private String lastName;
    private Integer age;

    public Person(String firstName, String lastName, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public static Person GetDefaultPerson() {
        return new Person("NA", "NA", 0);
    }

    public static Boolean IsDefaultPerson(Person person) {
        Objects.requireNonNull(person);
        return person.equals(Person.GetDefaultPerson());
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ", " + age + " years old";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return firstName.equals(person.firstName) &&
                lastName.equals(person.lastName) &&
                age.equals(person.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age);
    }
}
