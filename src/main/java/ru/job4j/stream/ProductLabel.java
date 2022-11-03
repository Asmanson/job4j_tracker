package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class ProductLabel {
    public List<String> generateLabels(List<Product> products) {
        return products.stream()
                .filter(product -> (product.getStandard() - product.getActual()) < 4)
                .filter(product -> (product.getStandard() - product.getActual()) > -1)
                .map(product -> new Label(product.getName(), product.getPrice() / 2))
                .map(product -> product.toString())
                .collect(Collectors.toList());
    }
}