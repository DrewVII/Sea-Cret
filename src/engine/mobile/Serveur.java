package engine.mobile;

import engine.map.Block;

public class Serveur extends Staff {
	private int niveau;

	public Serveur(int argent, int niveau, Block position) {
		super(argent, position);
		this.niveau = niveau;
	}

	public int getNiveau() {
		return niveau;
	}
	
	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}
	
}
