package com.serenitydojo.fruitcalculator.generals;

public class Officer {
    private final String name;

    public Officer(String name) {
        this.name = name;
    }

    public void ordersSubordinatesToCarryOut(Order... orders) {
        for(Order order : orders) {
            order.performAs(this);
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
