package org.fmi.plovdiv.model;

import java.util.ArrayList;
import java.util.List;

public class IcecreamOrder {

    private List<AbstractIcecream> icecreams;
    private EnjoymentStrategy enjoymentStrategy;

    public IcecreamOrder(EnjoymentStrategy enjoymentStrategy) {
        this.icecreams = new ArrayList<>();
        this.enjoymentStrategy = enjoymentStrategy;
    }

    public void addIcecream(AbstractIcecream icecream) {
        icecreams.add(icecream);
    }


    public String getOrderDetails() {
        StringBuilder details = new StringBuilder("Order details:\n");
        for (AbstractIcecream icecream : icecreams) {
            details.append(icecream.description()).append("\n");
        }
        details.append("Cost: " + getTotalCost()).append("\n");
        if (enjoymentStrategy != null) {
            details.append("Пожелаваме приятно хапване и нека да ви е сладко" + enjoymentStrategy.enjoy());
        }
        return details.toString();
    }

    public double getTotalCost() {
        double totalCost = 0;
        for (AbstractIcecream icecream : icecreams) {
            totalCost += icecream.cost();
        }
        return totalCost;
    }
}
