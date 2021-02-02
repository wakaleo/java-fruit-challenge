package com.serenitydojo.fruitcalculator.generals;

public class MarchForward implements Order {
    private final int distance;

    public MarchForward(int distance) {
        this.distance = distance;
    }

    @Override
    public void performAs(Officer officer) {
        System.out.println(officer + " marches forward " + distance + " km" );
    }
}
