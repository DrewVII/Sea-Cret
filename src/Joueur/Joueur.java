package Joueur;

public class Joueur {
	private int argent;
	private int lvl;
	private int reputation;

	
	
	public Joueur(){
		this.argent = 100;
		this.lvl = 0;
		this.reputation = 1;
	}
	
	public int getArgent() {
		return argent;
	}
	
	public int getLvl() {
		return lvl;
	}
	
	public int getReputation() {
		return reputation;
	}
}
