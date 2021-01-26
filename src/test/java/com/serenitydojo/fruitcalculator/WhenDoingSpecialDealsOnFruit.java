package com.serenitydojo.fruitcalculator;

import com.serenitydojo.fruitcalculator.discounts.BulkDiscount;
import com.serenitydojo.fruitcalculator.discounts.Discount;
import com.serenitydojo.fruitcalculator.discounts.FixedPriceDiscount;
import com.serenitydojo.fruitcalculator.discounts.PercentageDiscount;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * The catalog should support the following special deals on fruit:
 *  - Fixed discount (e.g $1 off)
 *  - Percentage discount (e.g. 10% off)
 *  - 2 for the price of 3
 */
public class WhenDoingSpecialDealsOnFruit {

    FruitCatalog fruitCatalog = new FruitCatalog();

    @Before
    public void setupCatalog() {
        fruitCatalog.addFruit(Fruit.Orange, 3.00);
        fruitCatalog.addFruit(Fruit.Apple, 2.00);
        fruitCatalog.addFruit(Fruit.Strawberry, 5.00);
        fruitCatalog.addFruit(Fruit.Banana, 10.00);
    }

    @Test
    public void for_fixed_discounted_prices() {
        // There is a $2 discount on bananas
        Discount fixedPriceDiscount = new FixedPriceDiscount(2.50);
        fruitCatalog.addDiscount(Fruit.Banana, fixedPriceDiscount);

        ShoppingCart cart = new ShoppingCart(fruitCatalog);

        cart.add(1, Fruit.Banana);
        cart.add(1, Fruit.Apple);

        assertThat(cart.getTotalPrice()).isEqualTo(9.50);
    }

    @Test
    public void for_percentage_discounts() {
        Discount percentageDiscount = new PercentageDiscount(10);
        fruitCatalog.addDiscount(Fruit.Banana, percentageDiscount);

        ShoppingCart cart = new ShoppingCart(fruitCatalog);

        cart.add(1, Fruit.Banana);
        cart.add(1, Fruit.Apple);

        assertThat(cart.getTotalPrice()).isEqualTo(11.00);
    }

    @Test
    public void two_for_price_of_three() {
        Discount bulkDiscount = new BulkDiscount(3,2);
        fruitCatalog.addDiscount(Fruit.Apple, bulkDiscount);

        ShoppingCart cart = new ShoppingCart(fruitCatalog);

        cart.add(3, Fruit.Apple);

        assertThat(cart.getTotalPrice()).isEqualTo(4.00);

    }

    @Test
    public void two_for_price_of_three_with_multiples() {
        Discount bulkDiscount = new BulkDiscount(3,2);
        fruitCatalog.addDiscount(Fruit.Apple, bulkDiscount);

        ShoppingCart cart = new ShoppingCart(fruitCatalog);

        cart.add(6, Fruit.Apple);

        assertThat(cart.getTotalPrice()).isEqualTo(8.00);

    }

}
