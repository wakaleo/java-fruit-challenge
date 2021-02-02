package com.serenitydojo.generals;

import com.serenitydojo.fruitcalculator.generals.*;
import org.junit.Test;

public class WhenGivingOrders {

    @Test
    public void a_general_can_order_to_do_stuff() {
        General general = new General("George");
        Officer ollie = new Officer("Ollie");
        Officer orla = new Officer("Orla");

        general.commands(ollie, orla);

        Order marchForward = new MarchForward(100);

        general.ordersSubordinatesTo(marchForward);
        general.ordersSubordinatesTo(MarchBackwards.aDistanceOf(100));
        general.ordersSubordinatesTo(new Order() {
            @Override
            public void performAs(Officer officer) {
                System.out.println("Clean the barracks");
            }
        });
        general.ordersSubordinatesTo(
                officer -> System.out.println("Clean the barracks")
        );
    }

}
