package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;

import javax.swing.JPanel;

import config.GameConfiguration;
import engine.outil.Chaise;
import engine.outil.Table;
import engine.map.Block;
import engine.map.Map;
import engine.mobile.Client;
import engine.mobile.Cuisinier;
import engine.mobile.Serveur;
import engine.process.MobileElementManager;


public class GameDisplay extends JPanel {

	private static final long serialVersionUID = 1L;

	private Map map;
	private MobileElementManager manager;
	private PaintStrategy paintStrategy = new PaintStrategy(manager);

	public GameDisplay(Map map, MobileElementManager manager) {
		this.map = map;
		this.manager = manager;
	}

	@Override
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    paintStrategy.paint(map, g);
	    
	   /* Graphics g2 = (Graphics2D) g;
	    paintStrategy.paint(manager.getTable(), g2);
		*/
	    // Vérification du nombre de serveurs juste avant de les dessiner
	    //System.out.println("Nombre de serveurs : " + manager.getServeurs().size());
	    if(manager.getPlayer().getLvlRestaurant()==2) {
	    	paintStrategy.replaceLvl2(manager, g, map);
	    }   
	    if(manager.getPlayer().getLvlRestaurant()==3) {
	    	paintStrategy.replaceLvl2(manager, g, map);
	    	paintStrategy.replaceLvl3(manager, g, map);
	    	
	    }
	    
	    for (Serveur serveur : manager.getServeurs()) {
	        Graphics2D g2 = (Graphics2D) g;
	        paintStrategy.paint(serveur, g2);
	    }
	    
	    for (Table table: manager.getTables()) {
            Graphics2D g2 = (Graphics2D) g;
                paintStrategy.paint(table,g2); // Utilisez la nouvelle méthode pour dessiner les clients
            }
	    ////////////////////////////
	    for (Chaise chaise: manager.getChaises()) {
            Graphics2D g2 = (Graphics2D) g;
                paintStrategy.paint(chaise,g2); // Utilisez la nouvelle méthode pour dessiner les clients
            }
	    ////////////////////////////////////
        
	    // Vérification du nombre de clients juste avant de les dessiner
	    //System.out.println("Nombre de client : " + manager.getClients().size());

	    for (Client client : manager.getClients()) {
	        if (client != null) { // Vérifiez que le client n'est pas null avant de le dessiner
	            paintStrategy.paint(client, g); // Utilisez la nouvelle méthode pour dessiner les clients
	        }
	    }
	    Cuisinier cuisinier = manager.getCuisinier();
        Graphics2D g3 = (Graphics2D) g;
        paintStrategy.paint(cuisinier, g3);
	}
	public void updateGame() {
	    manager.nextRound(); // Suppose que cette méthode met à jour l'état et supprime le client si nécessaire
	    repaint(); // Cela rafraîchit l'affichage après la mise à jour de l'état
	}
	
	public void performGameUpdate() {
	    manager.nextRound();
	    updateGame(); // Cela appelle repaint à la fin
	}
	

}
