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
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate("q1E+");
                });
        assertThat(exception.getMessage()).isEqualTo("Длина пароля меньше 8 или больше 32");
    }

    @Test
    public void whenPasswordSubstrings() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate("ytr12TyqweRTy");
                });
        assertThat(exception.getMessage()).isEqualTo("Пароль содержит недопустимые подстроки");
    }

    @Test
    public void whenPasswordNotUpper() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate("qweqdfdfjh12376+");
                });
        assertThat(exception.getMessage()).isEqualTo("В пароле отсутствуют символы в верхнем регистре");
    }

    @Test
    public void whenPasswordNotLower() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate("YERYRT126536+");
                });
        assertThat(exception.getMessage()).isEqualTo("В пароле отсутствуют символы в нижнем регистре");
    }

    @Test
    public void whenPasswordNotNumber() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate("YERYRTer+");
                });
        assertThat(exception.getMessage()).isEqualTo("В пароле отсутствуют цифры");
    }

    @Test
    public void whenPasswordNotSpec() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate("YERYRTwe23");
                });
        assertThat(exception.getMessage()).isEqualTo("В пароле отсутствуют спецсимволы");
    }

    @Test
    public void whenPasswordTrue() {
        String expected = "Пароль успешно создан";
        String password = "YERYRTwe23+";
        String out = PasswordValidator.validate(password);
        Assert.assertEquals(expected, out);
    }
}