package engine.outil;

import engine.menu.Ingredient;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Stock {
    private Map<Ingredient, Integer> ingredients;
    private Map<Ingredient, Integer> capaciteMax;

    public Stock() {
        this.ingredients = new HashMap<>();
        this.capaciteMax = new HashMap<>();
    }

    // Définir la capacité maximale pour un ingrédient
    public void definirCapaciteMax(Ingredient ingredient, int capacite) {
        capaciteMax.put(ingredient, capacite);
    }

    // Ajouter ou acheter des ingrédients
    public void acheterIngredient(Ingredient ingredient, int quantite) {
        int quantiteActuelle = ingredients.containsKey(ingredient) ? ingredients.get(ingredient) : 0;
        int capacite = capaciteMax.containsKey(ingredient) ? capaciteMax.get(ingredient) : Integer.MAX_VALUE; // Si aucune capacité n'est définie, la capacité est maximale
        int nouvelleQuantite = Math.min(capacite, quantiteActuelle + quantite);

        ingredients.put(ingredient, nouvelleQuantite);
    }
    
    // Utiliser des ingrédients
    public boolean utiliserIngredient(Ingredient ingredient, int quantiteUtilisee) {
        if (!ingredients.containsKey(ingredient)) {
            return false;
        }
        int quantiteActuelle = ingredients.get(ingredient);
        if (quantiteActuelle >= quantiteUtilisee) {
            ingredients.put(ingredient, quantiteActuelle - quantiteUtilisee);
            return true;
        } else {
            return false;
        }
    }

    // Obtenir le stock actuel pour un ingrédient
    public int getQuantite(Ingredient ingredient) {
        return ingredients.getOrDefault(ingredient, 0);
    }

    public boolean estIngredientDisponible(Ingredient ingredient, int quantiteNecessaire) {
        return ingredients.getOrDefault(ingredient, 0) >= quantiteNecessaire;
    }

    public boolean sontIngrédientsDisponibles(List<Ingredient> ingredientsNecessaires) {
        for (Ingredient ingredient : ingredientsNecessaires) {
            if (!estIngredientDisponible(ingredient, 1)) {
                return false;
            }
        }
        return true;
    }

    public void afficherStock() {
        System.out.println("Stock actuel :");
        for (Map.Entry<Ingredient, Integer> entry : ingredients.entrySet()) {
            System.out.println(entry.getKey().getNom() + ": " + entry.getValue());
        }
    }
}
