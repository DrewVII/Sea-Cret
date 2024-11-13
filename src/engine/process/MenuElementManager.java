package engine.process;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import engine.menu.*;
import engine.outil.Stock;

public class MenuElementManager {
	
	private Stock stock;
	private ListeIngredient listeIngredient;
	
    public MenuElementManager(Stock stock, ListeIngredient listeIngredient) {
        this.stock = stock;
        this.listeIngredient = listeIngredient; // Initialisation avec la liste des ingrédients
    }
    public Stock getStock() {
    	return stock;
    }
	
	   public void ajouterDessertNiveau1(List<Nourriture> choixFinal, Menu menu) {
	        Random random = new Random();
	        List<Dessert> dessertsNiveauSpecifique = new ArrayList<>();
	        // Filtrer les desserts par le niveau spécifié
	        for (Dessert dessert : menu.getDesserts()) {
	            if (dessert.getLvl() == 1 && stock.sontIngrédientsDisponibles(dessert.getIngredients())) {
	                dessertsNiveauSpecifique.add(dessert);
	            }
	        }
	        // Ajouter un dessert aléatoire de ce niveau à la liste des choix, s'il y en a
	        if (!dessertsNiveauSpecifique.isEmpty()) {
	            choixFinal.add(dessertsNiveauSpecifique.get(random.nextInt(dessertsNiveauSpecifique.size())));
	        }
	    }
	    public void ajouterDessertNiveau2(List<Nourriture> choixFinal, Menu menu) {
	        Random random = new Random();
	        List<Dessert> dessertsNiveauSpecifique = new ArrayList<>();
	        // Filtrer les desserts par le niveau spécifié
	        for (Dessert dessert : menu.getDesserts()) {
	            if (dessert.getLvl() == 2 && stock.sontIngrédientsDisponibles(dessert.getIngredients())) {
	                dessertsNiveauSpecifique.add(dessert);
	            }
	        }
	        // Ajouter un dessert aléatoire de ce niveau à la liste des choix, s'il y en a
	        if (!dessertsNiveauSpecifique.isEmpty()) {
	            choixFinal.add(dessertsNiveauSpecifique.get(random.nextInt(dessertsNiveauSpecifique.size())));
	        }
	    }
	    public void ajouterDessertNiveau3(List<Nourriture> choixFinal, Menu menu) {
	        Random random = new Random();
	        List<Dessert> dessertsNiveauSpecifique = new ArrayList<>();
	        // Filtrer les desserts par le niveau spécifié
	        for (Dessert dessert : menu.getDesserts()) {
	            if (dessert.getLvl() == 3 && stock.sontIngrédientsDisponibles(dessert.getIngredients())) {
	                dessertsNiveauSpecifique.add(dessert);
	            }
	        }
	        // Ajouter un dessert aléatoire de ce niveau à la liste des choix, s'il y en a
	        if (!dessertsNiveauSpecifique.isEmpty()) {
	            choixFinal.add(dessertsNiveauSpecifique.get(random.nextInt(dessertsNiveauSpecifique.size())));
	        }
	    }
	    public void ajouterEntreeNiveau1(List<Nourriture> choixFinal, Menu menu) {
	        Random random = new Random();
	        List<Entree> entreesNiveauSpecifique = new ArrayList<>();
	        // Filtrer les desserts par le niveau spécifié
	        for (Entree entree : menu.getEntrees()) {
	            if (entree.getLvl() == 1 && stock.sontIngrédientsDisponibles(entree.getIngredients())) {
	                entreesNiveauSpecifique.add(entree);
	            }
	        }
	        // Ajouter un dessert aléatoire de ce niveau à la liste des choix, s'il y en a
	        if (!entreesNiveauSpecifique.isEmpty()) {
	            choixFinal.add(entreesNiveauSpecifique.get(random.nextInt(entreesNiveauSpecifique.size())));
	        }
	    }
	    public void ajouterEntreeNiveau2(List<Nourriture> choixFinal, Menu menu) {
	        Random random = new Random();
	        List<Entree> entreesNiveauSpecifique = new ArrayList<>();
	        // Filtrer les desserts par le niveau spécifié
	        for (Entree entree : menu.getEntrees()) {
	            if (entree.getLvl() == 2 && stock.sontIngrédientsDisponibles(entree.getIngredients())) {
	                entreesNiveauSpecifique.add(entree);
	            }
	        }
	        // Ajouter un dessert aléatoire de ce niveau à la liste des choix, s'il y en a
	        if (!entreesNiveauSpecifique.isEmpty()) {
	            choixFinal.add(entreesNiveauSpecifique.get(random.nextInt(entreesNiveauSpecifique.size())));
	        }
	    }
	    public void ajouterEntreeNiveau3(List<Nourriture> choixFinal, Menu menu) {
	        Random random = new Random();
	        List<Entree> entreesNiveauSpecifique = new ArrayList<>();
	        // Filtrer les desserts par le niveau spécifié
	        for (Entree entree : menu.getEntrees()) {
	            if (entree.getLvl() == 3 && stock.sontIngrédientsDisponibles(entree.getIngredients())) {
	                entreesNiveauSpecifique.add(entree);
	            }
	        }
	        // Ajouter un dessert aléatoire de ce niveau à la liste des choix, s'il y en a
	        if (!entreesNiveauSpecifique.isEmpty()) {
	            choixFinal.add(entreesNiveauSpecifique.get(random.nextInt(entreesNiveauSpecifique.size())));
	        }
	    }
	    public void ajouterPlatNiveau1(List<Nourriture> choixFinal, Menu menu) {
	        Random random = new Random();
	        List<Plat> platsNiveauSpecifique = new ArrayList<>();
	        // Filtrer les desserts par le niveau spécifié
	        for (Plat plat : menu.getPlats()) {
	            if (plat.getLvl() == 1 && stock.sontIngrédientsDisponibles(plat.getIngredients())) {
	                platsNiveauSpecifique.add(plat);
	            }
	        }
	        // Ajouter un dessert aléatoire de ce niveau à la liste des choix, s'il y en a
	        if (!platsNiveauSpecifique.isEmpty()) {
	            choixFinal.add(platsNiveauSpecifique.get(random.nextInt(platsNiveauSpecifique.size())));
	        }
	    }
	    public void ajouterPlatNiveau2(List<Nourriture> choixFinal, Menu menu) {
	        Random random = new Random();
	        List<Plat> platsNiveauSpecifique = new ArrayList<>();
	        // Filtrer les desserts par le niveau spécifié
	        for (Plat plat : menu.getPlats()) {
	            if (plat.getLvl() == 2 && stock.sontIngrédientsDisponibles(plat.getIngredients())) {
	                platsNiveauSpecifique.add(plat);
	            }
	        }
	        // Ajouter un dessert aléatoire de ce niveau à la liste des choix, s'il y en a
	        if (!platsNiveauSpecifique.isEmpty()) {
	            choixFinal.add(platsNiveauSpecifique.get(random.nextInt(platsNiveauSpecifique.size())));
	        }
	    }
	    public void ajouterPlatNiveau3(List<Nourriture> choixFinal, Menu menu) {
	        Random random = new Random();
	        List<Plat> platsNiveauSpecifique = new ArrayList<>();
	        // Filtrer les desserts par le niveau spécifié
	        for (Plat plat : menu.getPlats()) {
	            if (plat.getLvl() == 3 && stock.sontIngrédientsDisponibles(plat.getIngredients())) {
	                platsNiveauSpecifique.add(plat);
	            }
	        }
	        // Ajouter un dessert aléatoire de ce niveau à la liste des choix, s'il y en a
	        if (!platsNiveauSpecifique.isEmpty()) {
	            choixFinal.add(platsNiveauSpecifique.get(random.nextInt(platsNiveauSpecifique.size())));
	        }
	    }
	    public void initialiserStockAvecIngrédientsDeDépart() {
	        // Supposons que ingredientList est accessible ici et que stock est déjà initialisé
	        for (Ingredient ingredient : listeIngredient.getIngredientList()) {
	            // Supposons que chaque ingrédient doit être acheté en quantité de 20
	            // Vous pouvez ajuster la quantité ici selon l'ingrédient si nécessaire
	            int quantiteAcheter = 20; // Quantité par défaut
	            
	            // Ajout de conditions spécifiques pour certains ingrédients, si nécessaire
	            if (ingredient.getNom().equals("Fugu") || ingredient.getNom().equals("Caviar")) {
	                quantiteAcheter = 5; // Quantité ajustée pour des ingrédients spéciaux
	            } else if (ingredient.getNom().equals("Or")) {
	                quantiteAcheter = 5; // Quantité ajustée pour l'ingrédient spécial "Or"
	            }
	            
	            // Acheter l'ingrédient et ajouter au stock
	            stock.acheterIngredient(ingredient, quantiteAcheter);
	        }
	    }
		public ListeIngredient getListeIngredient() {
			return this.listeIngredient;
		}


}
