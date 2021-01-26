package com.serenitydojo.fruitcalculator.discounts;

public interface Discount {
    double apply(double fullPrice);

    default double apply(double fullPrice, int quantity) {
        return apply(fullPrice);
    }
}
