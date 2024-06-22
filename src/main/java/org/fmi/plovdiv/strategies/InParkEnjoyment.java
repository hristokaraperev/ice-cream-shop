package org.fmi.plovdiv.strategies;

import org.fmi.plovdiv.model.EnjoymentStrategy;

public class InParkEnjoyment implements EnjoymentStrategy {

    @Override
    public String enjoy() {
        return " в парка!";
    }

}
