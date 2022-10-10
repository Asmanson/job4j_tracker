package ru.job4j.pojo;

public class Bus implements Transport {

    @Override
    public void drow() {
    }

    @Override
    public void passengers(int pass) {
    }

    @Override
    public double fuel(double liters, double price) {
        return price;
    }
}
