package com.serenitydojo.fruitcalculator.discounts;

public class FixedPriceDiscount implements Discount {
    private final double discountPrice;

    public FixedPriceDiscount(double discountPrice) {
        this.discountPrice = discountPrice;
    }

    @Override
    public double apply(double fullPrice) {
        return fullPrice - discountPrice;
    }
}
