package engine.mobile;

import engine.map.Block;
import system.Satisfaction;

public class Critique extends Client {
	private String nom;
	private String prenom;
	private String entreprise;
	
	public Critique(String nom, String prenom, String entreprise, Satisfaction satisfaction, Block position, int tempsAttente) {
		super(position, tempsAttente, tempsAttente, null, null);
		this.nom = nom;
		this.prenom = prenom;
		this.entreprise = entreprise;
	}
}
