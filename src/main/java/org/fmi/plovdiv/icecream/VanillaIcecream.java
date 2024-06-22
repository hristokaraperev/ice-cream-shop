package org.fmi.plovdiv.icecream;

import org.fmi.plovdiv.model.AbstractIcecream;

public class VanillaIcecream extends AbstractIcecream {

    @Override
    public String description() {
        return "Vanilla Icecream";
    }

    @Override
    public double cost() {
        return 1;
    }

}
