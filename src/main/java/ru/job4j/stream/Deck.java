package ru.job4j.stream;

import java.util.stream.*;

public class Deck {

    public enum Value {
        V_6, V_7, V_8
    }

    public enum Suit {
        Diamonds, Hearts, Spades, Clubs
    }

    private Suit suit;
    private Value value;

    public Deck(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public static void main(String[] args) {
        Stream.of(Suit.values())
                .flatMap(suit -> Stream.of(Value.values())
                        .map(value -> new Deck(suit, value)))
                .forEach(System.out::println);
    }

    public String toString() {
        return "Карта{"
                + "масть = " + suit
                + ", значение = " + value
                + '}';
    }
}