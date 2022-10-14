package ru.job4j.early;

import org.junit.Assert;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PasswordValidatorTest {

    @Test
    public void whenPasswordNull() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate(null);
                });
        assertThat(exception.getMessage()).isEqualTo("Пустой пароль");
    }

    @Test
    public void whenPasswordLength() {
        String expected = "Длина пароля меньше 8 или больше 32";
        String password = "ytr";
        String out = PasswordValidator.validate(password);
        Assert.assertEquals(expected, out);
    }

    @Test
    public void whenPasswordSubstrings() {
        String expected = "Пароль содержит недопустимые подстроки";
        String password = "ytr12TyqweRTy";
        String out = PasswordValidator.validate(password);
        Assert.assertEquals(expected, out);
    }

    @Test
    public void whenPasswordNotUpper() {
        String expected = "В пароле отсутствуют символы в верхнем регистре";
        String password = "qweqdfdfjh12376+";
        String out = PasswordValidator.validate(password);
        Assert.assertEquals(expected, out);
    }

    @Test
    public void whenPasswordNotLower() {
        String expected = "В пароле отсутствуют символы в нижнем регистре";
        String password = "YERYRT126536+";
        String out = PasswordValidator.validate(password);
        Assert.assertEquals(expected, out);
    }

    @Test
    public void whenPasswordNotNumber() {
        String expected = "В пароле отсутствуют цифры";
        String password = "YERYRTwe+";
        String out = PasswordValidator.validate(password);
        Assert.assertEquals(expected, out);
    }

    @Test
    public void whenPasswordNotSpec() {
        String expected = "В пароле отсутствуют спецсимволы";
        String password = "YERYRTwe23";
        String out = PasswordValidator.validate(password);
        Assert.assertEquals(expected, out);
    }

    @Test
    public void whenPasswordTrue() {
        String expected = "Пароль успешно создан";
        String password = "YERYRTwe23+";
        String out = PasswordValidator.validate(password);
        Assert.assertEquals(expected, out);
    }
}