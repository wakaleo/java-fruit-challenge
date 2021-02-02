package com.serenitydojo.fruitcalculator.generals;

public class MarchBackwards implements Order {
    private final int distance;

    public static Order aDistanceOf(int distance) {
        return new MarchBackwards(distance);
    }

    public MarchBackwards(int distance) {
        this.distance = distance;
    }

    @Override
    public void performAs(Officer officer) {
        System.out.println(officer + " marches backwards " + distance + " km" );
    }
}
