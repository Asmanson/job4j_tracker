package ru.job4j.pojo;

public class Bus implements Transport {

    @Override
    public void drow() {
        System.out.println("МАЗ");
    }

    @Override
    public void passengers(int pass) {
        System.out.println("Пассажиров в автобусе " + pass);
    }

    @Override
    public double fuel(double liters, double price) {
        return price * liters;
    }
}
