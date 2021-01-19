package com.serenitydojo.fruitcalculator;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final FruitCatalog fruitCatalog;
    private List<ShoppingCartItem> items = new ArrayList<>();

    public ShoppingCart(FruitCatalog fruitCatalog) {
        this.fruitCatalog = fruitCatalog;
    }

    public void add(int quantity, Fruit fruit) {
        double itemCost = quantity * fruitCatalog.costOf(fruit);
        items.add(new ShoppingCartItem(fruit.name(), quantity, itemCost));
    }

    public double getTotalPrice() {
        return items.stream()
                .mapToDouble(item -> item.getItemCost())
                .sum();
    }
}
