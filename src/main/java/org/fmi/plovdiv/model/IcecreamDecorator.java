package org.fmi.plovdiv.model;

public abstract class IcecreamDecorator extends AbstractIcecream {

    protected AbstractIcecream decoratedIcecream;

    public IcecreamDecorator(AbstractIcecream decoratedIcecream) {
        this.decoratedIcecream = decoratedIcecream;
    }

}
