package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int minus(int y) {
        return y - x;
    }

    public int divide(int y) {
        return y/x;
    }

    public int multiply(int y) {
        return x * y;
    }

    public static int sum(int y) {
        return x + y;
    }

    public int sumAllOperation(int a) {
        return sum(a) + minus(a) + multiply(a) + divide(a);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int rls = calculator.sumAllOperation(10);
        System.out.println(rls);
    }
}
