package ru.job4j.tracker;

import java.util.Arrays;
public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (items[index].getId() == id) {
                return items[index];
            }
        }
        return null;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        int sizecoppy = 0;
        Item[] rsl = new Item[size];
        for (int index = 0; index < size; index++) {
            if (items[index].getName().equals(key)) {
                rsl[sizecoppy] = items[index];
                sizecoppy++;
            }
        }
        return Arrays.copyOf(rsl, sizecoppy);
    }
}