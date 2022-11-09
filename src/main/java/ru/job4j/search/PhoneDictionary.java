package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.*;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> containName = (person) -> person.getName().contains(key);
        Predicate<Person> containSurname = (person) -> person.getSurname().contains(key);
        Predicate<Person> containPhone = (person) -> person.getPhone().contains(key);
        Predicate<Person> containAddress = (person) -> person.getAddress().contains(key);
        Predicate<Person> combine = containName.or(containSurname.or(containPhone.or(containAddress)));
        ArrayList<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
