package system;

import engine.mobile.*;
import player.Player;

public class Satisfaction {
    private int score;
	private int tempsAttente;
    private Serveur serveur; // Ajout de la référence au Serveur
    private Player player;

    public Satisfaction(int tempsAttente, Serveur serveur, Player player) {
        this.score = 0;
        this.tempsAttente = tempsAttente;
        this.serveur = serveur;
        this.player = player;
        
    }
	
	public int calculScoreSatisfaction() {
		int lvlServeur = serveur.getNiveau();
		int lvlRestaurant = player.getLvlRestaurant();
		int tempsIdeal = 10;
		if(tempsAttente < tempsIdeal) {
			score+=2;	
		}
		if(lvlServeur==1) {
			score++;
		}
		if(lvlServeur==2) {
			score++;
		}
		if(lvlServeur==3) {
			score++;
		}
		if(lvlRestaurant<2) {
			score++;
		}
		return score;
		
	}
	
	public void setScore(int score) {
		this.score = score;
	}
}
