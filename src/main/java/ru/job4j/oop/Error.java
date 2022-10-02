package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println(active);
        System.out.println(status);
        System.out.println(message);
    }

    public static void main(String[] args) {
        Error errordefault = new Error();
        Error errorargfals = new Error(false, 0, "Ложь");
        Error errorargtrue = new Error(true, 1, "Истина");
        errordefault.printInfo();
        errorargfals.printInfo();
        errorargtrue.printInfo();
    }
}
