package ru.job4j.early;

public class PasswordValidator {

    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Пустой пароль");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Длина пароля меньше 8 или больше 32");
        }
        String[] specsymbol = new String[] {"qwerty", "12345", "password", "admin", "user"};
        for (String passwordindex : specsymbol) {
            if (password.toLowerCase().contains(passwordindex)) {
                throw new IllegalArgumentException("Пароль содержит недопустимые подстроки");
            }
        }
        char[] arraypassword = password.toCharArray();
        boolean result = true;
        for (char x : arraypassword) {
            if (Character.isUpperCase(x)) {
                result = false;
                break;
            }
        }
        if (result) {
            throw new IllegalArgumentException("В пароле отсутствуют символы в верхнем регистре");
        }
        result = true;
        for (char x : arraypassword) {
            if (Character.isLowerCase(x)) {
                result = false;
                break;
            }
        }
        if (result) {
            throw new IllegalArgumentException("В пароле отсутствуют символы в нижнем регистре");
        }
        result = true;
        for (char x : arraypassword) {
            if (Character.isDigit(x)) {
                result = false;
                break;
            }
        }
        if (result) {
            throw new IllegalArgumentException("В пароле отсутствуют цифры");
        }
        result = true;
        for (char x : arraypassword) {
            if (!Character.isDigit(x) && !Character.isAlphabetic(x)) {
                result = false;
                break;
            }
        }
        if (result) {
            throw new IllegalArgumentException("В пароле отсутствуют спецсимволы");
        }
        return "Пароль успешно создан";
    }
}