package machine;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Stock {
    List<IngredientWithQuantity> ingredientWithQuantities;

    public Stock(List<IngredientWithQuantity> ingredientWithQuantities) {
        this.ingredientWithQuantities = ingredientWithQuantities;
    }

    public void readStock(Scanner scanner) {
        for (int i = 0; i < ingredientWithQuantities.size() - 1; i++) {
            System.out.printf("Write how many %s of %s you want to add:\n",
                    ingredientWithQuantities.get(i).getIngredient().getUnit(),
                    ingredientWithQuantities.get(i).getIngredient().getName());
            ingredientWithQuantities.get(i).setQuantity(Integer.parseInt(scanner.nextLine()) + ingredientWithQuantities.get(i).getQuantity());
        }
        System.out.printf("Write how many disposable %s you want to add:\n",
                ingredientWithQuantities.get(ingredientWithQuantities.size() - 1).getIngredient().getName());
        ingredientWithQuantities.get(ingredientWithQuantities.size() - 1).setQuantity(Integer.parseInt(scanner.nextLine()) + ingredientWithQuantities.get(ingredientWithQuantities.size() - 1).getQuantity());
        System.out.println();
    }

    public void writeStock() {
        System.out.println("The coffee machine has:");
        for (int i = 0; i < ingredientWithQuantities.size() - 1; i++) {
            System.out.printf("%d %s of %s\n",
                    ingredientWithQuantities.get(i).getQuantity(),
                    ingredientWithQuantities.get(i).getIngredient().getUnit(),
                    ingredientWithQuantities.get(i).getIngredient().getName());
        }
        System.out.printf("%d disposable %s\n",
                ingredientWithQuantities.get(ingredientWithQuantities.size() - 1).getQuantity(),
                ingredientWithQuantities.get(ingredientWithQuantities.size() - 1).getIngredient().getName());
    }

    public int maximumProduceable(Recipe recipe) {
        return ingredientWithQuantities.stream().map(s -> {
                    int available = s.getQuantity();
                    int needed = recipe.neededQuantityOfIngredient(s.getIngredient());
                    return available / (needed != 0 ? needed : 1);
                })
                .mapToInt(i -> i)
                .min().orElse(0);
    }

    public List<IngredientWithQuantity> missigIngredients(int requiredQuantity, Recipe recipe) {
        return recipe.getIngredientQuantities().stream().filter(recipeIngredient ->
                !hasIngredientAvailableStockQuantity(recipeIngredient.getIngredient(), recipeIngredient.getQuantity() * requiredQuantity)
        ).toList();
    }

    public void make(int requiredQuantity, Recipe recipe) {
        recipe.getIngredientQuantities().forEach(recipeIngredient -> substract(recipeIngredient.getIngredient(), recipeIngredient.getQuantity() * requiredQuantity));
    }

    private void substract(Ingredient igredient, int neededQuantity) {
        Optional<IngredientWithQuantity> ingredientWithQuantity = ingredientWithQuantities.stream()
                .filter(iq -> iq.getIngredient().equals(igredient))
                .findFirst();
        ingredientWithQuantity.ifPresent(withQuantity -> withQuantity.setQuantity(withQuantity.getQuantity() - neededQuantity));
    }

    private boolean hasIngredientAvailableStockQuantity(Ingredient igredient, int neededQuantity) {
        Optional<IngredientWithQuantity> ingredientWithQuantity = ingredientWithQuantities.stream()
                .filter(iq -> iq.getIngredient().equals(igredient))
                .findFirst();

        return ingredientWithQuantity.filter(withQuantity -> withQuantity.getQuantity() > neededQuantity).isPresent();
    }

}
