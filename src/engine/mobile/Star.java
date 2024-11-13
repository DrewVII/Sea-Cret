package engine.mobile;

import engine.map.Block;
import system.Satisfaction;

public class Star extends Client {
	private String nom;
	private String prenom;
	
	public Star(String nom, String prenom,Block position, int tempsAttente) {
		super(position, tempsAttente, tempsAttente, null, null);
		this.nom = nom;
		this.prenom = prenom;
	}
}