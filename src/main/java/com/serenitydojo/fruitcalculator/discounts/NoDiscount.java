package com.serenitydojo.fruitcalculator.discounts;

public class NoDiscount implements Discount {
    @Override
    public double apply(double fullPrice) {
        return fullPrice;
    }
}
