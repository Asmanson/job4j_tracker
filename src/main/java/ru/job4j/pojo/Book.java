package ru.job4j.pojo;

public class Book {
    private String namebook;
    private int numberpage;

    public Book(String namebook, int numberpage) {
        this.namebook = namebook;
        this.numberpage = numberpage;
    }

    public String getNamebook() {
        return namebook;
    }

    public void setNamebook(String namebook) {
        this.namebook = namebook;
    }

    public int getNumberpage() {
        return numberpage;
    }

    public void setNumberpage(int numberpage) {
        this.numberpage = numberpage;
    }
}
