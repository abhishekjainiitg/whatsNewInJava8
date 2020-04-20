package com.Java8.DataAndTime;

import java.time.LocalDate;

public class Person {
    private String firstName;
    private LocalDate dob;

    public Person(String firstName, LocalDate dob) {
        this.firstName = firstName;
        this.dob = dob;
    }

    public String getFirstName() {
        return firstName;
    }

    public LocalDate getDob() {
        return dob;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", dob=" + dob +
                '}';
    }
}
