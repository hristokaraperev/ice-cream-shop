package org.fmi.plovdiv.decorators;

import org.fmi.plovdiv.model.AbstractIcecream;
import org.fmi.plovdiv.model.IcecreamDecorator;

public class ChocolateGlazeDecorator extends IcecreamDecorator {

    public ChocolateGlazeDecorator(AbstractIcecream decoratedIcecream) {
        super(decoratedIcecream);
    }

    @Override
    public String description() {
        return this.decoratedIcecream.description() + " with Chocolate Glaze";
    }

    @Override
    public double cost() {
        return this.decoratedIcecream.cost() + 0.4;
    }

}
