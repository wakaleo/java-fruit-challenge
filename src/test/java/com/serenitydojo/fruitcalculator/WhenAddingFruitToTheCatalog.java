package com.serenitydojo.fruitcalculator;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/*
The shop sells apples, oranges, bananas, pears, peaches and other fruit, depending on availability.
For example the prices per kilo for the currently available fruit are:
Apples: $4.00
Oranges: $5.50
Bananas: $6.00
Pears: $4.50
You can update the catalog with the current market price of a fruit
 */
public class WhenAddingFruitToTheCatalog {

    FruitCatalog fruitCatalog;

    @Before
    public void createCatalog() {
         fruitCatalog = new FruitCatalog();
    }
    @Test
    public void the_catalog_contains_the_fruit_currently_for_sale() {
        // Given apples cost 4.00
        fruitCatalog.addFruit(Fruit.Apple, 4.00);

        // When I get the price of an apple
        double price = fruitCatalog.costOf(Fruit.Apple);

        // It should be $4.00
        assertThat(price).isEqualTo(4.00);
    }

    /*
    The Catalog should list the names of the currently available fruit in alphabetical order
     */
    @Test
    public void the_catalog_should_list_fruit_in_alphabetical_order() {
        fruitCatalog.addFruit(Fruit.Orange, 3.00);
        fruitCatalog.addFruit(Fruit.Apple, 3.00);
        fruitCatalog.addFruit(Fruit.Strawberry, 3.00);
        fruitCatalog.addFruit(Fruit.Banana, 3.00);

        assertThat(fruitCatalog.getAvailableFruit()).containsExactly("Apple","Banana","Orange","Strawberry");
    }

    /*
    The Catalog should throw a FruitUnavailableException if the fruit is not currently available
     */
    @Test(expected = FruitUnavailableException.class)
    public void should_throw_exception_if_fruit_not_available() {
        fruitCatalog.addFruit(Fruit.Orange, 3.00);

        fruitCatalog.costOf(Fruit.Apple);
    }

    /**
     * Adding items to the cart
     */
    @Test
    public void should_keep_running_total_of_items_in_cart() {
        fruitCatalog.addFruit(Fruit.Orange, 3.00);
        fruitCatalog.addFruit(Fruit.Apple, 4.00);

        ShoppingCart cart = new ShoppingCart(fruitCatalog);

        cart.add(1, Fruit.Apple);
        cart.add(2, Fruit.Orange);

        assertThat(cart.getTotalPrice()).isEqualTo(10.0);
    }
}
