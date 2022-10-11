package ru.job4j.pojo;

public class Autobus implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " колесит по городу в поисках пассажиров");
    }
}
