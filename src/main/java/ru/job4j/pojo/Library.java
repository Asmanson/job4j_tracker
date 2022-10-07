package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book bookone = new Book("Clean code", 20);
        Book booktwo = new Book("War and peace", 1200);
        Book bookthree = new Book("Monkeyluv", 350);
        Book bookfour = new Book("Marabou stork nightmares", 400);
        Book[] bookstore = new Book[4];
        bookstore[0] = bookone;
        bookstore[1] = booktwo;
        bookstore[2] = bookthree;
        bookstore[3] = bookfour;
        for (int index = 0; index < bookstore.length; index++) {
            System.out.println(bookstore[index].getNamebook() + ", " + bookstore[index].getNumberpage());
        }
        bookstore[0] = bookstore[3];
        bookstore[3] = bookone;
        for (int index = 0; index < bookstore.length; index++) {
            System.out.println(bookstore[index].getNamebook() + ", " + bookstore[index].getNumberpage());
        }
        for (int index = 0; index < bookstore.length; index++) {
            if ("Clean code".equals(bookstore[index].getNamebook())) {
                System.out.println(bookstore[index].getNamebook() + ", " + bookstore[index].getNumberpage());
            }
        }
    }
}
