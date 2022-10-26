package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class ItemTest {
    @Test
    public void sortItems() {
        List<Item> items = Arrays.asList(
                new Item(4, "Fix bugs"),
                new Item(3, "Impl task"),
                new Item(5, "Reboot server")
        );
        Collections.sort(items);
        List<Item> expected = Arrays.asList(
                new Item(3, "Impl task"),
                new Item(4, "Fix bugs"),
                new Item(5, "Reboot server")
        );
        Assert.assertEquals(items, expected);
    }
}