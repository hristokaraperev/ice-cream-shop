package org.fmi.plovdiv.factories;

import org.fmi.plovdiv.icecream.ChocolateIcecream;
import org.fmi.plovdiv.icecream.StrawberryIcecream;
import org.fmi.plovdiv.icecream.VanillaIcecream;
import org.fmi.plovdiv.model.AbstractIcecream;

public class IcecreamFactory {

    public AbstractIcecream createIcecream(String type) {
        switch (type) {
            case "vanilla":
                return new VanillaIcecream();
            case "chocolate":
                return new ChocolateIcecream();
            case "strawberry":
                return new StrawberryIcecream();
            default:
                throw new IllegalArgumentException("unknown ice cream type");
        }
    }

}
