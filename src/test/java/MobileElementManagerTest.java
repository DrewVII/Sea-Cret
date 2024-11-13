package test.java;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import engine.map.Block;
import engine.map.Map;
import engine.menu.*;
import engine.mobile.Client;
import engine.mobile.Cuisinier;
import engine.mobile.Serveur;
import engine.outil.Stock;
import engine.process.MenuElementManager;
import engine.process.MobileElementManager;
import player.Player;

import java.util.ArrayList;
import java.util.List;

public class MobileElementManagerTest {

    private MobileElementManager manager;
    private MenuElementManager managerMenu;
    private Menu menu;
    private Cuisinier cuisinier;
    private Player player;
    private Map map;
    private Stock stock; // Ajout d'un stock
    private Serveur serveur;
	private Client client;

    @BeforeEach
    public void setUp() {
        client = new Client(new Block(0,0), 20, 0, serveur, player);
        map = new Map(10, 10);
        menu = new Menu();
        cuisinier = new Cuisinier(100, 1, new Block(0, 0));
        List<Cuisinier> cuisiniers = new ArrayList<>();
        cuisiniers.add(cuisinier);
        stock = new Stock();
        ListeIngredient listeIngredient = new ListeIngredient();
        // Supposons que listeIngredient est correctement initialisé quelque part ici
        managerMenu = new MenuElementManager(stock,listeIngredient); // Supposons que cela initialise correctement le stock
        managerMenu.initialiserStockAvecIngrédientsDeDépart(); // Utilise la liste des ingrédients
        player = new Player(1000, 0, 0, 1, menu, new ArrayList<>(), cuisiniers, new ArrayList<>(), stock, null, 0);
        manager = new MobileElementManager(map, player, serveur, client, stock);
        manager.setCuisinier(cuisinier);
    }
    


    @Test
    public void testChoosePourNiveau1Cuisinier() {
        cuisinier.setNiveau(1);
        List<Nourriture> choixFinal = manager.choose(menu, client);
        assertNotEquals(0, choixFinal.size(), "Le choix pour un cuisinier de niveau 1 ne devrait pas être vide.");

    }

    @Test
    public void testChoosePourNiveau2Cuisinier() {
        cuisinier.setNiveau(2);
        List<Nourriture> choixFinal = manager.choose(menu, client);
        assertNotEquals(0, choixFinal.size(), "Le choix pour un cuisinier de niveau 2 ne devrait pas être vide.");

    }

    @Test
    public void testChoosePourNiveau3Cuisinier() {
        cuisinier.setNiveau(3);
        List<Nourriture> choixFinal = manager.choose(menu, client);
        assertNotEquals(0, choixFinal.size(), "Le choix pour un cuisinier de niveau 3 ne devrait pas être vide.");
     
    }
    @Test
    public void testInitialisationDuStock() {
        // Vérifier que le stock contient un ingrédient spécifique avec la quantité attendue
        // Exemple : vérifier si le stock contient 20 unités de "Tomate"
        int quantiteTomate = stock.getQuantite(new Ingredient("Tomate", 10));
        assertEquals(20, quantiteTomate, "Le stock devrait contenir 20 unités de Tomate.");
        
        // Vous pouvez ajouter d'autres vérifications pour différents ingrédients selon le besoin
        // Par exemple, vérifier pour l'ingrédient "Fugu" avec une quantité attendue de 5
        int quantiteFugu = stock.getQuantite(new Ingredient("Fugu", 500));
        assertEquals(5, quantiteFugu, "Le stock devrait contenir 5 unités de Fugu.");
    }

    // Ajouter d'autres tests si nécessaire
}
