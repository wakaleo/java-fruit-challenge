package com.serenitydojo.fruitcalculator;

import java.util.*;
import java.util.stream.Collectors;

public class FruitCatalog {

    private Map<Fruit, Double> fruitPrices = new HashMap<>();

    public void addFruit(Fruit fruit, double cost) {
        fruitPrices.put(fruit, cost);
    }

    public double costOf(Fruit fruit) {
        if (!fruitPrices.containsKey(fruit)) {
            throw new FruitUnavailableException();
        }
        return fruitPrices.get(fruit);
    }

    public List<String> getAvailableFruit() {
        return fruitPrices.keySet().stream()
                .map(Enum::name)
                .sorted()
                .collect(Collectors.toList());
    }
}
