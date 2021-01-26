package com.serenitydojo.fruitcalculator.discounts;

public class PercentageDiscount implements Discount {
    private final int percentageDiscount;

    public PercentageDiscount(int percentageDiscount) {
        this.percentageDiscount = percentageDiscount;
    }

    @Override
    public double apply(double fullPrice) {
        return fullPrice - (percentageDiscount/100.00) * fullPrice;
    }
}
