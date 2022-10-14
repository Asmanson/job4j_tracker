package ru.job4j.early;

public class PasswordValidator {

    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Пустой пароль");
        }
        if (password.length() < 8 || password.length() > 32) {
            return "Длина пароля меньше 8 или больше 32";
        }
        if (password.toLowerCase().contains("qwerty") || password.toLowerCase().contains("12345")
                || password.toLowerCase().contains("password") || password.toLowerCase().contains("admin")
                || password.toLowerCase().contains("user")) {
            return "Пароль содержит недопустимые подстроки";
        }
        char[] arraypassword = password.toCharArray();
        boolean result = true;
        for (char x:arraypassword) {
            if (Character.isUpperCase(x)) {
                result = false;
                break;
            }
        }
        if (result) {
            return "В пароле отсутствуют символы в верхнем регистре";
        }
        result = true;
        for (char x:arraypassword) {
            if (Character.isLowerCase(x)) {
                result = false;
                break;
            }
        }
        if (result) {
            return "В пароле отсутствуют символы в нижнем регистре";
        }
        result = true;
        for (char x:arraypassword) {
            if (Character.isDigit(x)) {
                result = false;
                break;
            }
        }
        if (result) {
            return "В пароле отсутствуют цифры";
        }
        result = true;
        for (char x:arraypassword) {
            if (!Character.isDigit(x) && !Character.isAlphabetic(x)) {
                result = false;
                break;
            }
        }
        if (result) {
            return "В пароле отсутствуют спецсимволы";
        }
        return "Пароль успешно создан";
    }
}