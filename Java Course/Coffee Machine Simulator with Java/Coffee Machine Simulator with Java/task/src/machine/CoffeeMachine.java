package machine;

import java.util.List;
import java.util.Scanner;

public class CoffeeMachine {

    private final Recipe espressoRecipe;
    private final Recipe latteRecipe;
    private final Recipe chapuchinoRecipe;
    private final Stock stock;
    private final Money money;

    public CoffeeMachine() {
        Ingredient water = new Ingredient("water", "ml");
        Ingredient milk = new Ingredient("milk", "ml");
        Ingredient coffeeBeans = new Ingredient("coffe beans", "g");
        Ingredient cups = new Ingredient("cups", "");

        stock = new Stock(
                List.of(
                        new IngredientWithQuantity(water, 400),
                        new IngredientWithQuantity(milk, 540),
                        new IngredientWithQuantity(coffeeBeans, 120),
                        new IngredientWithQuantity(cups, 9)
                )
        );

        espressoRecipe = new Recipe("Coffe",
                List.of(
                        new IngredientWithQuantity(water, 250),
                        new IngredientWithQuantity(milk, 0),
                        new IngredientWithQuantity(coffeeBeans, 16),
                        new IngredientWithQuantity(cups, 1)
                )
        );
        latteRecipe = new Recipe("Coffe",
                List.of(
                        new IngredientWithQuantity(water, 350),
                        new IngredientWithQuantity(milk, 75),
                        new IngredientWithQuantity(coffeeBeans, 20),
                        new IngredientWithQuantity(cups, 1)
                )
        );
        chapuchinoRecipe = new Recipe("Coffe",
                List.of(
                        new IngredientWithQuantity(water, 200),
                        new IngredientWithQuantity(milk, 100),
                        new IngredientWithQuantity(coffeeBeans, 12),
                        new IngredientWithQuantity(cups, 1)
                )
        );
        money = new Money(550);
    }

    private void sellCoffe(int selectedCoffee) {
        int income = 0;
        Recipe recipe = null;

        switch (selectedCoffee) {
            case 1:
                recipe = espressoRecipe;
                income = 4;
                break;
            case 2:
                recipe = latteRecipe;
                income = 7;
                break;
            default:
                recipe = chapuchinoRecipe;
                income = 6;
                break;
        }

        List<IngredientWithQuantity> missing = stock.missigIngredients(1, recipe);
        if (missing.isEmpty()) {
            System.out.println("I have enough resources, making you a coffee!\n");
            stock.make(1, recipe);
            money.setMoney(money.getMoney() + income);
        } else {
            System.out.println("Sorry not enough " + String.join(", ", missing.stream()
                    .map(i -> i.getIngredient().getName())
                    .toList()) + "!\n");
        }
    }

    public void operate() {
        Scanner scanner = new Scanner(System.in);
        String action;

        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            action= scanner.nextLine();

            switch (action) {
                case "buy":
                    System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                    String input  = scanner.nextLine();
                    if (input.equals("back")){
                        break;
                    }
                    int selectedCoffee = Integer.parseInt(input);
                    sellCoffe(selectedCoffee);
                    break;
                case "fill":
                    System.out.println();
                    stock.readStock(scanner);
                    break;
                case "take":
                    money.take();
                    break;
                case "remaining":
                    System.out.println();
                    stock.writeStock();
                    money.writeAmmount();
                    break;
                case "exit":
                    return;
                default:
                    break;
            }
        }
    }

    public static void main(String[] args) {
        CoffeeMachine machine = new CoffeeMachine();
        machine.operate();
    }
}
