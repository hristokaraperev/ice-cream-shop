package org.fmi.plovdiv.strategies;

import org.fmi.plovdiv.model.EnjoymentStrategy;

public class OnBeachEnjoyment implements EnjoymentStrategy {

    @Override
    public String enjoy() {
        return " на плажа!";
    }

}
