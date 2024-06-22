package org.fmi.plovdiv.icecream;

import org.fmi.plovdiv.model.AbstractIcecream;

public class ChocolateIcecream extends AbstractIcecream {

    @Override
    public String description() {
        return "Chocolate Icecream";
    }

    @Override
    public double cost() {
        return 1.2;
    }


}
