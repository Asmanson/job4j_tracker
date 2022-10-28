package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] leftnumb = left.split(". ");
        String[] rightnumb = right.split(". ");
        return Integer.compare(Integer.parseInt(leftnumb[0]), Integer.parseInt(rightnumb[0]));
    }
}