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


    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
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

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        item.setId(id);
        items[index] = item;
        return index != -1;
    }
}