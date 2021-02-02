package com.serenitydojo.fruitcalculator.generals;

import java.util.Arrays;
import java.util.List;

public class General {
    private final String name;
    private List<Officer> officers;

    public General(String name) {

        this.name = name;
    }

    public void commands(Officer... officers) {
        this.officers = Arrays.asList(officers);
    }

    public void ordersSubordinatesTo(Order... orders) {
        for(Officer officer : officers) {
            officer.ordersSubordinatesToCarryOut(orders);
        }
    }
}
