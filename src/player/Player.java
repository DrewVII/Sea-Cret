package player;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import engine.map.Block;
import engine.menu.*;
import engine.mobile.*;
import engine.outil.*;
import system.Reputation;

public class Player {
	private int argent;
	private int depenses;
	private int benefices;
	private int lvlRestaurant;
	private int reputation;
	private Menu menu;
	private List<Serveur> serveurs = new ArrayList<Serveur>();
	private List<Cuisinier> cuisiniers = new ArrayList<Cuisinier>();
	private List<Table> tables = new ArrayList<Table>();
	private List<Chaise> chaises = new ArrayList<Chaise>();
	private Stock stock;
	private String argentFile;
    private String repFile;
    private String levelFile;

    public Player(int argent, int depenses, int benefices, int lvlRestaurant, Menu menu, List<Serveur> serveurs,
            List<Cuisinier> cuisiniers, List<Table> tables,Stock stock, List<Chaise> chaises, int reputation) {
        String argentFile = "argent.txt";
        String repFile = "rep.txt";
        String levelFile = "level.txt";
		
		this.argent = argent;
		this.depenses = depenses;
		this.benefices = benefices;
		this.lvlRestaurant = lvlRestaurant;
		this.menu = menu;
		this.serveurs = serveurs;
		this.cuisiniers = cuisiniers;
		this.tables = tables;
		this.stock =stock;
		this.chaises=chaises;
		this.reputation = reputation;
	}
	public int getArgent() {
		return argent;
	}
	public int getDepenses() {
		return depenses;
	}
	public int getBenefices() {
		return benefices;
	}
	public int getLvlRestaurant() {
		return lvlRestaurant;
	}
	public Menu getMenu() {
		return menu;
	}
	public List<Serveur> getServeurs() {
		return serveurs;
	}
	public List<Chaise>getChaises(){
		return chaises;
	}
	public List<Cuisinier> getCuisiniers() {
		return cuisiniers;
	}
	public List<Table> getTables() {
		return tables;
	}
	public void setArgent(int argent) {
		this.argent = argent;
	}
	public void setDepenses(int depenses) {
		this.depenses = depenses;
	}
	public void setBenefices(int benefices) {
		this.benefices = benefices;
	}
	public void setLvlRestaurant(int lvlRestaurant) {
		this.lvlRestaurant = lvlRestaurant;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	public void setServeurs(List<Serveur> serveurs) {
		this.serveurs = serveurs;
	}
	public void setCuisiniers(List<Cuisinier> cuisiniers) {
		this.cuisiniers = cuisiniers;
	}
	public void setTables(List<Table> tables) {
		this.tables = tables;
	}
	public void setChaises(List<Chaise> chaises) {
		this.chaises = chaises;
	}
	public int getReputation() {
		return reputation;
	}
	public void setReputation(int reputation) {
		this.reputation = reputation;
	}
	public Stock getStock() {
		return stock;
	}
	 public Boolean upgradeRestaurantLvl2() {
	        if (lvlRestaurant == 1 && argent >= 10000) {
	            lvlRestaurant++;
	            argent -= 5000;
	            return true;
	        }
	        return false;
	    }

	    public Boolean upgradeRestaurantLvl3() {
	        if (lvlRestaurant == 2 && argent >= 30000) {
	            lvlRestaurant++;
	            argent -= 15000;
	            return true;
	        }
	        return false;
	    }
	    public static Block placeLibre(ArrayList<Chaise> chaises) {
	        for (Chaise chaise : chaises) {
	            if (chaise.getState() == true) {
	                // Si une chaise est libre, retourne ses coordonnées
	                return chaise.getPosition();
	            }
	        }
	        // Si aucune chaise n'est libre, retourne null
	        return null;
	    }
	    public void saveGame() {
            try {
                BufferedWriter writerArg = new BufferedWriter(new FileWriter(argentFile));
                BufferedWriter writerRep = new BufferedWriter(new FileWriter(repFile));
                BufferedWriter writerLvl = new BufferedWriter(new FileWriter(levelFile));

                writerArg.write(argent);
                writerRep.write(reputation);
                writerLvl.write(lvlRestaurant);

                writerArg.close();
                writerRep.close();
                writerLvl.close();
            }
            catch(NumberFormatException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        public void loadGame() {
            try {
                BufferedReader readerArg = new BufferedReader(new FileReader(argentFile));
                BufferedReader readerRep = new BufferedReader(new FileReader(repFile));
                BufferedReader readerLvl = new BufferedReader(new FileReader(levelFile));

                argent = Integer.parseInt(readerArg.readLine());
                reputation = Integer.parseInt(readerRep.readLine());
                lvlRestaurant = Integer.parseInt(readerLvl.readLine());

                readerArg.close();
                readerRep.close();
                readerLvl.close();
            }
            catch(NumberFormatException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        public void newGame() {
            argent = 1000;
            reputation = 1;
            lvlRestaurant = 1;
        }
}
