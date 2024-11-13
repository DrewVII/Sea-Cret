package engine.menu;

import java.util.*;


public class Plat extends Nourriture {
	
	public Plat(int prix, String nom, int lvl,ArrayList<Ingredient> ingredients) {
		super(prix, nom, lvl, ingredients);
	}
	public boolean isPlat(){
		return true;
	}
	public boolean isEntree(){
		return false;
	}
	public boolean isDessert(){
		return false;
	}
	public String toString() {
	    return "Plat{nom='" + getNom() + "', prix=" + getPrix() + ", niveau=" + getLvl() + "}";
	}
}
