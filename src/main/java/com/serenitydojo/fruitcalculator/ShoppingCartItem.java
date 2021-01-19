package com.serenitydojo.fruitcalculator;

public class ShoppingCartItem {
    private final String itemName;
    private final int quantity;
    private final double itemCost;

    public ShoppingCartItem(String item, int quantity, double itemCost) {
        this.itemName = item;
        this.quantity = quantity;
        this.itemCost = itemCost;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public double getItemCost() {
        return itemCost;
    }
}
