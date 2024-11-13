package engine.mobile;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import engine.map.Block;
import engine.menu.*;
import engine.outil.Chaise;
import system.Satisfaction;

import engine.mobile.*;
import player.Player;

public class Client extends MobileElement {
	private Satisfaction satisfaction;
	private int tempsAttente;
	private int attenteNourriture;
	private List<Nourriture> choixFinal;
	//////Etat
	////// 0 = client vient de spawn et n'as pas encore choisit
	////// 1 = client à choisit
	////// 2 = serveur à pris commande
	////// 3 = serveur à aporter plat
	////// 4 = client à finit plat
	////// 5 = serveur à débarasser client disparait et paye

	
	private int etat = 0;
	
	public Client( Block position, int tempsAttente, int attenteNourriture, Serveur serveur, Player player) {
		super(position);
		this.attenteNourriture = 0;
		satisfaction = new Satisfaction(0, serveur, player);
	}

	public int getTempsAttente() {
		return tempsAttente;
	}

	public int getEtat() {
		return etat;
	}
	
	public void incrementEtat() {
		etat=etat+1;		
	}
	
	public int setAndGetSat() {
		int tp = attenteNourriture;
		satisfaction.setScore(tp);
		tp = satisfaction.calculScoreSatisfaction();
		
		return tp;
	}

	public void setChoixFinal(List<Nourriture> choixFinal) {
		this.choixFinal = choixFinal;
	}
	
	public List<Nourriture> getChoixFinal(){
		return choixFinal;
	}
	
	public void temps() {
		this.tempsAttente++;
	}
	
	public int attenteNourriture() {
		return attenteNourriture;
	}
	
	public void attenteNourriturePlus() {
		attenteNourriture++;
	}
	
}


