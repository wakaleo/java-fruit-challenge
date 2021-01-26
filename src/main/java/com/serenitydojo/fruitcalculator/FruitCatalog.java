package com.serenitydojo.fruitcalculator;

import com.serenitydojo.fruitcalculator.discounts.Discount;
import com.serenitydojo.fruitcalculator.discounts.NoDiscount;

import java.util.*;
import java.util.stream.Collectors;

public class FruitCatalog {

    private Map<Fruit, Double> fruitPrices = new HashMap<>();
    private Map<Fruit, Discount> discounts = new HashMap<>();

    private static final Discount FULL_PRICE = new NoDiscount();

    public void addFruit(Fruit fruit, double cost) {
        fruitPrices.put(fruit, cost);
    }

    public double costOf(Fruit fruit) {
        return costOf(fruit, 1);
    }

    public double costOf(Fruit fruit, int quantity) {
        if (!fruitPrices.containsKey(fruit)) {
            throw new FruitUnavailableException();
        }
        double fullPrice = fruitPrices.get(fruit);
        Discount applicableDiscount = discounts.getOrDefault(fruit, FULL_PRICE);
        return quantity * applicableDiscount.apply(fullPrice, quantity);
    }

    public List<String> getAvailableFruit() {
        return fruitPrices.keySet().stream()
                .map(Enum::name)
                .sorted()
                .collect(Collectors.toList());
    }

    public void addDiscount(Fruit fruit, Discount discount) {
        discounts.put(fruit, discount);
    }
}
