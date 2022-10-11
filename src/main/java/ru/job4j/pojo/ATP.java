package ru.job4j.pojo;

public class ATP {
    public static void main(String[] args) {
        Vehicle cargoplane = new Airplane();
        Vehicle passplane = new Airplane();
        Vehicle infinitetrain = new Train();
        Vehicle maz103 = new Autobus();
        Vehicle[] vehicles = new Vehicle[]{cargoplane, passplane, infinitetrain, maz103};
        for (Vehicle a : vehicles) {
            a.move();
        }
    }
}
