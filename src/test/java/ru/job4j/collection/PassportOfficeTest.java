package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class PassportOfficeTest {
    @Test
    public void whenTestAddMethod() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport())).isEqualTo(citizen);
    }

    @Test
    public void whenTestAddFalseMethod() {
        Citizen citizenone = new Citizen("2f44a", "Petr Arsentev");
        Citizen citizentwo = new Citizen("2f44a", "Ivan Asmanov");
        PassportOffice office = new PassportOffice();
        office.add(citizenone);
        assertFalse(office.add(citizentwo));
    }
}