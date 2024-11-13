package engine.menu;

import java.util.*;


public class Dessert extends Nourriture{
	
	public Dessert(int prix, String nom, int lvl,ArrayList<Ingredient> ingredients) {
		super(prix, nom, lvl, ingredients);
	}
	public boolean isPlat(){
		return false;
	}
	public boolean isEntree(){
		return false;
	}
	public boolean isDessert(){
		return true;
	}
	public String toString() {
	    return "Dessert{nom='" + getNom() + "', prix=" + getPrix() + ", niveau=" + getLvl() + "}";
	}
}
