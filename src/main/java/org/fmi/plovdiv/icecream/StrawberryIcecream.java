package org.fmi.plovdiv.icecream;

import org.fmi.plovdiv.model.AbstractIcecream;

public class StrawberryIcecream extends AbstractIcecream {

    @Override
    public String description() {
        return "Strawberry Icecream";
    }

    @Override
    public double cost() {
        return 1.4;
    }



}
