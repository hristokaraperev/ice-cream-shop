package org.fmi.plovdiv;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TerminalApplication {

    private static Scanner scanner = new Scanner(System.in);
    private static OrderProcessor orderProcessor = new OrderProcessor(scanner);
    private static DeveloperMenu developerMenu = new DeveloperMenu(scanner);

    private static boolean DEVMODE;

    public static void main(String[] args) {
        if (args.length > 0 && args[0] != null) {
            if (args[0].equalsIgnoreCase("dev")) {
                DEVMODE = true;
            }
        }
        while (true) {
            showMainMenu();
            int choice = 0;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("Невалиден избор. Моля опитайте отново!");
            }
            processMainMenuChoice(choice);
        }
    }

    private static void showMainMenu() {
        System.out.println("Добре дошли в магазина за сладолед!");
        System.out.println("1. Направете поръчка");
        if (DEVMODE) {
            System.out.println("2. Контролен панел");
        }
        System.out.println("0. Изход");
        System.out.print("Моля изберете: ");
    }

    private static void processMainMenuChoice(int choice) {
        switch (choice) {
            case 1:
                orderProcessor.placeOrder();
                break;
            case 2:
                if (DEVMODE) {
                    developerMenu.showDeveloperMenu();
                } else {
                    System.out.println("Невалиден избор. Опитайте отново.");
                }
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Невалиден избор. Опитайте отново.");
        }
    }
}
