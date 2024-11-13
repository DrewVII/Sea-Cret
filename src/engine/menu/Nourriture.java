package engine.menu;

import java.util.ArrayList;

public abstract class Nourriture {
	private ArrayList<Ingredient> ingredients;
	private int prix;
	private String nom;
	private int lvl;
	
	public Nourriture(int prix, String nom, int lvl,ArrayList<Ingredient> ingredients) {
		this.ingredients=ingredients;
		this.prix=prix;
		this.nom=nom;
		this.lvl=lvl;
	}
	public String getNom() {
		return nom;
	}
	public int getLvl() {
		return lvl;
	}
	public int getPrix() {
		return prix;
	}
	public ArrayList<Ingredient> getIngredients() {
	        return new ArrayList<>(ingredients); // Retourne une copie de la liste pour éviter la modification externe
	}
}
