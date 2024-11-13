package engine.menu;

import java.util.*;



public class Entree extends Nourriture {
	public Entree(int prix, String nom, int lvl, ArrayList<Ingredient> ingredients) {
		super(prix, nom, lvl, ingredients);
	}
	public boolean isPlat(){
		return false;
	}
	public boolean isEntree(){
		return true;
	}
	public boolean isDessert(){
		return false;
	}
	public String toString() {
	    return "Entree{nom='" + getNom() + "', prix=" + getPrix() + ", niveau=" + getLvl() + "}";
	}
}
