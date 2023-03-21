package ru.netology;

import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age;
    protected String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Person(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public boolean hasAge() {
        return age > 0;
    }

    public boolean hasAddress() {
        return !address.isEmpty();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return OptionalInt.of(age);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if(hasAge()) {
            this.age++;
        }
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder childBuilder = new PersonBuilder();
        childBuilder.setSurname(this.surname);
        childBuilder.setAge(1);
        childBuilder.setAddress(this.address);
        return childBuilder;
    }

    @Override
    public String toString() {
        return String.format("Имя: %s%nФамилия: %s%nВозраст: %s%nАдрес: %s%n", name, surname, hasAge() ? age : "не определён", hasAddress() ? address : "не определён");
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }
}
