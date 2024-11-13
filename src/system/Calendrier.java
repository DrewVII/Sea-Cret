package system;

import config.GameConfiguration;

public class Calendrier {
	private int jour;
	private int temps;
	
	public Calendrier(int jour, int temps) {
		this.jour = jour;
		this.temps = temps;
	}
	
	public int getJour() {
		return jour;
	}
	
	public void setJour(int jour) {
		this.jour = jour;
	}
	
	public void passJour() {
		jour++;
	}
	
	public void resetTemps() {
		temps = GameConfiguration.PARTY_DURATION;
	}
	
	public int getTemps() {
		return temps;
	}
	
	public void setTemps(int temps) {
		this.temps = temps;
	}
	
	public String toString() {
		return "Jour "+jour+"\nTemps restant avant la fin de la journée : "+temps+"s";
	}
}
