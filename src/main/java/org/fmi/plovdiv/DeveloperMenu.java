package org.fmi.plovdiv;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.fmi.plovdiv.model.IcecreamOrder;
import org.fmi.plovdiv.model.IcecreamShop;

public class DeveloperMenu {

    private Scanner scanner;
    private IcecreamShop shop = IcecreamShop.getInstance();

    public DeveloperMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void showDeveloperMenu() {
        System.out.println("Меню за управление:");
        System.out.println("1. Виж всички поръчки");
        System.out.println("2. Обратно към основното меню");
        System.out.print("Моля въведете: ");

        int choice = 0;
        try {
            choice = scanner.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println("Невалиден избор. Моля опитайте отново!");
        }

        switch (choice) {
            case 1:
                viewOrders();
                break;
            case 2:
                break;
            default:
                System.out.println("Невалиден избор. Връщане към основното меню.");
        }
    }

        private void viewOrders() {
        List<IcecreamOrder> orders = shop.getOrders();

        if (orders.isEmpty()) {
            System.out.println("No orders found.");
        } else {
            for (IcecreamOrder order : orders) {
                System.out.println(order.getOrderDetails());
            }
        }
    }

}
