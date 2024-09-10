package machine;

import java.util.List;
import java.util.Optional;

public class Recipe {

    private final List<IngredientWithQuantity> ingredientQuantities;

    private final String name;

    public Recipe(String name, List<IngredientWithQuantity> ingredientQuantities) {
        this.ingredientQuantities = ingredientQuantities;
        this.name = name;
    }

    public List<IngredientWithQuantity> getIngredientQuantities() {
        return ingredientQuantities;
    }


    public int neededQuantityOfIngredient(Ingredient ingredient) {
        Optional<IngredientWithQuantity> ingredientQuantity = ingredientQuantities.stream()
                .filter(iq -> iq.getIngredient().equals(ingredient))
                .findFirst();
        return ingredientQuantity.map(IngredientWithQuantity::getQuantity).orElse(0);

    }
}
