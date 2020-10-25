package machine;

import java.util.Scanner;

public class CoffeeMachine {

    public static Scanner scan = new Scanner(System.in);
    public static int water = 400;
    public static int milk = 540;
    public static int coffeeBeans = 120;
    public static int cups = 9;
    public static int money = 550;

    public static void main(String[] args) {

        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String command = scan.next();

            if (command.equals("exit")) {
                break;
            }
            machineAction(command);
        }
    }

    public static void machineAction(String command) {
        switch (command) {
            case "buy":
                System.out.println("What do you want to buy? 1 - espresso, " +
                        "2 - latte, 3 - cappuccino, back - to main menu:");
                String coffeeID = scan.next();
                switch (coffeeID) {
                    case "1": //espresso
                        hasEnough(250, 0, 16, 4);
                        break;
                    case "2": //latte
                        hasEnough(350, 75, 20, 7);
                        break;
                    case "3": //cappuccino
                        hasEnough(200, 100, 12, 6);
                        break;
                    case "back":
                        break;
                    default:
                        System.out.println("Not a valid choice");
                        break;
                }
                System.out.println();
                break;
            case "fill":
                fill();
                break;

            case "take":
                take();
                break;
            case "remaining":
                printLevels();
                break;
            default:
                System.out.println("Not a valid command");
                break;
        }
    }

    public static void printLevels() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffeeBeans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money");
        System.out.println();
    }

    public static void fill() {
        System.out.println("Write how many ml of water do you want to add:");
        water += scan.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        milk += scan.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        coffeeBeans += scan.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        cups += scan.nextInt();
        System.out.println();
    }

    public static void take() {
        System.out.println("I gave you $" + money);
        money = 0;
        System.out.println();
    }

    public static void hasEnough(int requiredWater, int requiredMilk, int requiredCoffee, int price) {
        if (water - requiredWater < 0) {
            System.out.println("Sorry, not enough water");
        } else if (milk - requiredMilk < 0) {
            System.out.println("Sorry not enough milk");
        } else if (coffeeBeans - requiredCoffee < 0) {
            System.out.println("Sorry, not enough coffee");
        } else if (cups <= 0) {
            System.out.println("Sorry, not enough cups");
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            water -= requiredWater;
            milk -= requiredMilk;
            coffeeBeans -= requiredCoffee;
            cups--;
            money += price;
        }
    }
}
