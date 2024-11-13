package engine.menu;

import java.util.ArrayList;

public class ListeIngredient {
	private Ingredient saintJacquesI = new Ingredient("Saint Jacques", 25);
	private Ingredient soupe = new Ingredient("Soupe", 5);
	private Ingredient sardineI = new Ingredient("Sardine", 10);
	private Ingredient laitue = new Ingredient("Laitue", 15);
	private Ingredient tomate = new Ingredient("Tomate", 10);
	private Ingredient huitreI = new Ingredient("Huitre", 25);
	private Ingredient crevetteI = new Ingredient("Crevette", 20);
	private Ingredient caviarI = new Ingredient("Caviar", 500);
	private Ingredient crabeI = new Ingredient("Crabe", 50);
	private Ingredient frite = new Ingredient("Frite", 20);
	private Ingredient homardI = new Ingredient("Homard", 150);
	private Ingredient fuguI = new Ingredient("Fugu", 500);
	private Ingredient haricot = new Ingredient("Haricot", 10);
	private Ingredient saumonI = new Ingredient("Saumon", 30);
	private Ingredient riz = new Ingredient("Riz", 20);
	private Ingredient requinI = new Ingredient("Requin", 90);
	private Ingredient maquereauI = new Ingredient("Maquereau", 30);
	private Ingredient truiteI = new Ingredient("Truite", 25);
	private Ingredient calamarI = new Ingredient("Calamar", 25);
	private Ingredient poulpeI = new Ingredient("Poulpe", 25);
	private Ingredient soleI = new Ingredient("Sole", 30);
	private Ingredient harengI = new Ingredient("Hareng", 30);
	private Ingredient mouleI = new Ingredient("Moule", 20);
	private Ingredient lait = new Ingredient("Lait", 10);
	private Ingredient or = new Ingredient("Or", 120);
	private Ingredient gateauI = new Ingredient("Gateau", 20);
	private Ingredient fraise = new Ingredient("Fraise", 15);
	private Ingredient chocolat = new Ingredient("Chocolat", 15);
	
	public ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();
	
	public final ArrayList<Ingredient> saintJacques = new ArrayList<Ingredient>();
	public final ArrayList<Ingredient> soupePoisson = new ArrayList<Ingredient>();
	public final ArrayList<Ingredient> salade = new ArrayList<Ingredient>();
	public final ArrayList<Ingredient> huitre = new ArrayList<Ingredient>();
	public final ArrayList<Ingredient> crevette = new ArrayList<Ingredient>();
	public final ArrayList<Ingredient> caviar = new ArrayList<Ingredient>();
	public final ArrayList<Ingredient> crabe = new ArrayList<Ingredient>();
	public final ArrayList<Ingredient> homard = new ArrayList<Ingredient>();
	public final ArrayList<Ingredient> fugu = new ArrayList<Ingredient>();
	public final ArrayList<Ingredient> saumon = new ArrayList<Ingredient>();
	public final ArrayList<Ingredient> maquereau = new ArrayList<Ingredient>();
	public final ArrayList<Ingredient> truite = new ArrayList<Ingredient>();
	public final ArrayList<Ingredient> requin = new ArrayList<Ingredient>();
	public final ArrayList<Ingredient> calamar = new ArrayList<Ingredient>();
	public final ArrayList<Ingredient> poulpe = new ArrayList<Ingredient>();
	public final ArrayList<Ingredient> sole = new ArrayList<Ingredient>();
	public final ArrayList<Ingredient> hareng = new ArrayList<Ingredient>();
	public final ArrayList<Ingredient> moule = new ArrayList<Ingredient>();
	public final ArrayList<Ingredient> glace = new ArrayList<Ingredient>();
	public final ArrayList<Ingredient> gateauChocolat = new ArrayList<Ingredient>();
	public final ArrayList<Ingredient> cafe = new ArrayList<Ingredient>();
	public final ArrayList<Ingredient> gateauFraise = new ArrayList<Ingredient>();
	public final ArrayList<Ingredient> sardine = new ArrayList<Ingredient>();
	
	public ListeIngredient(){
		saintJacques.add(saintJacquesI);
		saintJacques.add(new Ingredient("Laittue", 5));
		
		soupePoisson.add(new Ingredient("Soupe", 5));
		soupePoisson.add(new Ingredient("Sardine", 10));
		
		salade.add(new Ingredient("Laittue", 15));
		salade.add(new Ingredient("Tomate", 10));
		
		huitre.add(new Ingredient("Huitre", 25));
		huitre.add(new Ingredient("Laittue", 5));
		
		crevette.add(new Ingredient("Crevette", 20));
		crevette.add(new Ingredient("Laittue", 5));
		
		
		caviar.add(new Ingredient("Caviar", 500));
		caviar.add(new Ingredient("Laittue", 5));
		
		crabe.add(new Ingredient("Crabe", 50));
		crabe.add(new Ingredient("Frite", 20));
		
		homard.add(new Ingredient("Homard", 150));
		homard.add(new Ingredient("Laittue", 5));
		
		fugu.add(new Ingredient("Fugu", 500));
		fugu.add(new Ingredient("Haricot", 10));
		
		saumon.add(new Ingredient("Saumon", 30));
		saumon.add(new Ingredient("Riz", 20));
		
		requin.add(new Ingredient("Requin", 90));
		requin.add(new Ingredient("Riz", 20));
		
		maquereau.add(new Ingredient("Maquereau", 30));
		maquereau.add(new Ingredient("Riz", 20));
		
		truite.add(new Ingredient("Truite", 25));
		truite.add(new Ingredient("Riz", 20));
		
		calamar.add(new Ingredient("Calamar", 25));
		calamar.add(new Ingredient("Haricot", 10));
		
		poulpe.add(new Ingredient("Poulpe", 25));
		poulpe.add(new Ingredient("Haricot", 10));
		
		sole.add(new Ingredient("Sole", 30));
		sole.add(new Ingredient("Riz", 20));
		
		hareng.add(new Ingredient("Hareng", 30));
		hareng.add(new Ingredient("Riz", 20));
		
		moule.add(new Ingredient("Moule", 20));
		moule.add(new Ingredient("Frite", 20));
		
		glace.add(new Ingredient("Lait", 10));
		glace.add(new Ingredient("Or", 120));
		
		
		gateauChocolat.add(new Ingredient("Chocolat", 15));
		gateauChocolat.add(new Ingredient("Gateau", 20));
		
		gateauFraise.add(new Ingredient("Fraise", 15));
		gateauFraise.add(new Ingredient("Gateau", 20));
		
		sardine.add(new Ingredient("Sardines", 25));
		sardine.add(new Ingredient("Haricot", 10));
		
		ingredientList.add(crabeI);
		ingredientList.add(crevetteI);
		ingredientList.add(fraise);
		ingredientList.add(frite);
		ingredientList.add(gateauI);
		ingredientList.add(harengI);
		ingredientList.add(huitreI);
		ingredientList.add(laitue);
		ingredientList.add(maquereauI);
		ingredientList.add(mouleI);
		ingredientList.add(poulpeI);
		ingredientList.add(requinI);
		ingredientList.add(saintJacquesI);
		ingredientList.add(sardineI);
		ingredientList.add(soleI);
		ingredientList.add(soupe);
		ingredientList.add(tomate);
		ingredientList.add(truiteI);
		ingredientList.add(calamarI);
		ingredientList.add(caviarI);
		ingredientList.add(chocolat);
		ingredientList.add(fuguI);
		ingredientList.add(haricot);
		ingredientList.add(homardI);
		ingredientList.add(lait);
		ingredientList.add(or);
		ingredientList.add(riz);
		ingredientList.add(saumonI);
		
	}
	
    public ArrayList<Ingredient> getIngredientList() {
        return ingredientList;
    }


}
