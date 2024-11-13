package engine.menu;

import java.util.ArrayList;
import java.util.List;


public class Menu {


	private List<Entree> entrees = new ArrayList<Entree>();
	private List<Plat> plats = new ArrayList<Plat>();
	private List<Dessert> desserts = new ArrayList<Dessert>();
	private ListeIngredient listeIngredient = new ListeIngredient();

	/////////////////////////////////////////////////////
	/////////////////////ENTREES/////////////////////////
	/////////////////////////////////////////////////////

	public final Entree SOUPE_DE_POISSON = new Entree(25,"Soupe de Poisson",1, listeIngredient.soupePoisson);
	public final Entree SALADE = new Entree(40,"Salade",1, listeIngredient.salade);
	public final Entree SAINT_JACQUES = new Entree(55,"Saint Jacques",2, listeIngredient.saintJacques);
	public final Entree CREVETTE = new Entree(55,"Crevette",2, listeIngredient.crevette);
	public final Entree HUITRE = new Entree(60,"Huitre",2, listeIngredient.huitre);
	public final Entree CAVIAR = new Entree(600,"Caviar",3, listeIngredient.caviar);
	
	/////////////////////////////////////////////////////
	/////////////////////PLATS/////////////////////////
	/////////////////////////////////////////////////////

	public final Plat POULPE = new Plat(45,"Poulpe",1, listeIngredient.poulpe);
	public final Plat MOULE = new Plat(50,"Moule",1, listeIngredient.moule);
	public final Plat TRUITE = new Plat(55,"Truite",1, listeIngredient.truite);
	public final Plat HARENG = new Plat(55,"Hareng",1, listeIngredient.hareng);
	public final Plat MAQUEREAU = new Plat(60,"Maquereau",1, listeIngredient.maquereau);
	public final Plat SAUMON = new Plat(65,"Saumon",1, listeIngredient.saumon);
	public final Plat CALAMAR = new Plat(65,"Calamar",2, listeIngredient.calamar);
	public final Plat SOLE = new Plat(70,"Sole",2, listeIngredient.sole);
	public final Plat CRABE = new Plat(100,"Crabe",2, listeIngredient.crabe);
	public final Plat REQUIN = new Plat(160,"Requin",3, listeIngredient.requin);
	public final Plat HOMARD = new Plat(250,"Homard",3, listeIngredient.homard);
	public final Plat FUGU = new Plat(700,"Fugu",3, listeIngredient.fugu);
	
	/////////////////////////////////////////////////////
	/////////////////////DESSERT///////////////////////////
	/////////////////////////////////////////////////////

	
	public final Dessert GATEAU_CHOCOLAT = new Dessert(45,"Gateau au chocolat",1, listeIngredient.gateauChocolat);
	public final Dessert GATEAU_FRAISE = new Dessert(75,"Gateau a la fraise",2, listeIngredient.gateauFraise);
	public final Dessert GLACE = new Dessert(150,"Glace feuille d'or",3, listeIngredient.glace);
	
	public Menu() {
		
			///////ENTREES/////////
		entrees.add(SOUPE_DE_POISSON);
		entrees.add(SALADE);
		entrees.add(SAINT_JACQUES);
		entrees.add(CREVETTE);
		entrees.add(HUITRE);
		entrees.add(CAVIAR);
			//////////PLATS//////////
		plats.add(POULPE);
		plats.add(MOULE);
		plats.add(TRUITE);
		plats.add(HARENG);
		plats.add(MAQUEREAU);
		plats.add(SAUMON);
		plats.add(CALAMAR);
		plats.add(SOLE);
		plats.add(CRABE);
		plats.add(REQUIN);
		plats.add(HOMARD);
		plats.add(FUGU);
			//////////DESSERT//////////
		desserts.add(GATEAU_CHOCOLAT);
		desserts.add(GATEAU_FRAISE);
		desserts.add(GLACE);
		
		
	}
    // Méthode pour obtenir la liste des entrées
    public List<Entree> getEntrees() {
        return entrees;
    }

    // Méthode pour obtenir la liste des plats
    public List<Plat> getPlats() {
        return plats;
    }

    // Méthode pour obtenir la liste des desserts
    public List<Dessert> getDesserts() {
        return desserts;
    }
    
}
