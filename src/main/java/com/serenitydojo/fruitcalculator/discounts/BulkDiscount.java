package com.serenitydojo.fruitcalculator.discounts;

public class BulkDiscount implements Discount {
    private final int discountableQuantity;
    private final int priceQuantity;

    public BulkDiscount(int discountableQuantity, int priceQuantity) {
        this.discountableQuantity = discountableQuantity;
        this.priceQuantity = priceQuantity;
    }

    @Override
    public double apply(double fullPrice) {
        return fullPrice;
    }

    @Override
    public double apply(double fullPrice, int purchasedQuantity) {
        if (purchasedQuantity % discountableQuantity == 0) {
            int numberOfLots = purchasedQuantity / discountableQuantity;
            return numberOfLots * fullPrice * ((double)priceQuantity / (double)purchasedQuantity);
        } else {
            return apply(fullPrice) * purchasedQuantity;
        }
    }
}
