package org.fmi.plovdiv;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.fmi.plovdiv.decorators.ChocolateGlazeDecorator;
import org.fmi.plovdiv.decorators.ChocolateSprinklesDecorator;
import org.fmi.plovdiv.factories.IcecreamFactory;
import org.fmi.plovdiv.model.AbstractIcecream;
import org.fmi.plovdiv.model.EnjoymentStrategy;
import org.fmi.plovdiv.model.IcecreamOrder;
import org.fmi.plovdiv.model.IcecreamShop;
import org.fmi.plovdiv.strategies.InParkEnjoyment;
import org.fmi.plovdiv.strategies.InShopEnjoyment;
import org.fmi.plovdiv.strategies.OnBeachEnjoyment;

public class OrderProcessor {

    private Scanner scanner;
    private IcecreamFactory icecreamFactory = new IcecreamFactory();
    private IcecreamShop shop = IcecreamShop.getInstance();

    public OrderProcessor(Scanner scanner) {
        this.scanner = scanner;
    }

    public void placeOrder() {
        List<AbstractIcecream> icecreams = new ArrayList<>();
        boolean moreIcecream = true;

        while (moreIcecream) {
            AbstractIcecream icecream = selectIcecreamType(); 
            icecream = addToppings(icecream);
            icecreams.add(icecream);
            System.out.println("Ще желаете ли друг сладолед? (да/не)");
            moreIcecream = scanner.next().equalsIgnoreCase("да");
        }

        EnjoymentStrategy enjoymentStrategy = askEnjoymentLocation();
        IcecreamOrder order = finalizeOrder(icecreams, enjoymentStrategy);
        shop.addOrder(order);

        System.out.println("Поръчката ви е регистрирана успешно! Хубав ден!");
        System.out.println(order.getOrderDetails());
    }

    public AbstractIcecream selectIcecreamType() {
        while (true) {
            System.out.println("Какъв тип сладолед желаете:");
            System.out.println("1. Ванилов");
            System.out.println("2. Шоколадов");
            System.out.println("3. Ягодов");
            System.out.print("Моля изберете: ");

            int choice = 0;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("Невалиден избор. Моля опитайте отново!");
            }
            
            switch (choice) {
                case 1:
                    return icecreamFactory.createIcecream("vanilla");
                case 2:
                    return icecreamFactory.createIcecream("chocolate");
                case 3:
                    return icecreamFactory.createIcecream("strawberry");
                default:
                    System.out.println("Невалиден избор. Моля опитайте отново!");
                    continue;
            }
        }

    }

    public AbstractIcecream addToppings(AbstractIcecream icecream) {
        boolean moreToppings = true;

        while (moreToppings) {
            System.out.println("Добавете екстри:");
            System.out.println("1. Шоколадова глазура");
            System.out.println("2. Шоколадови пръчици");
            System.out.println("3. Достатъчно екстри");
            System.out.print("Моля изберете: ");

            int choice = 0;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("Невалиден избор. Моля опитайте отново!");
            }

            switch (choice) {
                case 1:
                    icecream = new ChocolateGlazeDecorator(icecream);
                    break;
                case 2:
                    icecream = new ChocolateSprinklesDecorator(icecream);
                    break;
                case 3:
                    moreToppings = false;
                    break;
                default:
                    System.out.println("Невалиден избор. Няма добавена екстра.");
            }
        }
        return icecream;
    }

    public EnjoymentStrategy askEnjoymentLocation() {
        System.out.println("Къде ще се насладите на сладоледа си?");
        System.out.println("1. В магазина");
        System.out.println("2. В парка");
        System.out.println("3. На плажа");
        System.out.println("4. Предпочитам да не отговарям");
        System.out.print("Моля изберете: ");
        int choice = 0;
        try {
            choice = scanner.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println("Невалиден избор. Моля опитайте отново!");
        }

        switch (choice) {
            case 1:
                return new InShopEnjoyment();
            case 2:
                return new InParkEnjoyment();
            case 3:
                return new OnBeachEnjoyment();
            case 4:
                return null;
            default:
                System.out.println("Невалиден избор. Анкетата се пропуска.");
                return null;
        }   
    }
    
    public IcecreamOrder finalizeOrder(List<AbstractIcecream> icecreams, EnjoymentStrategy enjoymentStrategy) {
        IcecreamOrder order = new IcecreamOrder(enjoymentStrategy);

        for (AbstractIcecream icecream : icecreams) {
            order.addIcecream(icecream);
        }

        return order;
    }
}
