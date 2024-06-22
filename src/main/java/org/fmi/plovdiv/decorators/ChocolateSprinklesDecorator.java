package org.fmi.plovdiv.decorators;

import org.fmi.plovdiv.model.AbstractIcecream;
import org.fmi.plovdiv.model.IcecreamDecorator;

public class ChocolateSprinklesDecorator extends IcecreamDecorator{

    public ChocolateSprinklesDecorator(AbstractIcecream decoratedIcecream) {
        super(decoratedIcecream);
    }

    @Override
    public String description() {
        return this.decoratedIcecream.description() + " with Chocolate Sprinkles";
    }

    @Override
    public double cost() {
        return this.decoratedIcecream.cost() + 0.2;
    }

}
