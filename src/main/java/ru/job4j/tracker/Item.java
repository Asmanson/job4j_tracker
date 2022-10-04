package ru.job4j.tracker;

public class Item {
    private int id;
    private String name;

    public Item() {
    }

    public Item(String name) {
        setName(name);
    }

    public Item(String name, int id) {
        setName(name);
        setId(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Item item = new Item();
        Item itemone = new Item("AMD Ryzen");
        Item itemtwo = new Item("AMD Ryzen 7 3700X", 12);
    }
}