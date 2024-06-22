package org.fmi.plovdiv.model;

import java.util.ArrayList;
import java.util.List;

public class IcecreamShop {

    private static IcecreamShop INSTANCE;

    private IcecreamShop(){
        this.orders = new ArrayList<>();
    }

    public static IcecreamShop getInstance() {
        if (INSTANCE == null) {
            synchronized (IcecreamShop.class) {
                if (INSTANCE == null) {
                    INSTANCE = new IcecreamShop();
                }
            }
        }
        return INSTANCE;
    }

     private List<IcecreamOrder> orders;

     public void addOrder(IcecreamOrder order) {
        orders.add(order);
    }

    public List<IcecreamOrder> getOrders() {
        return orders;
    }
}
