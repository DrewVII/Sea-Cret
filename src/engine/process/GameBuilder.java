package engine.process;

import config.GameConfiguration;
import engine.map.Block;
import engine.map.Map;
import engine.menu.ListeIngredient;
import engine.mobile.Client;
import engine.mobile.Serveur;
import engine.outil.Stock;
import engine.outil.Table;
import player.Player;

public class GameBuilder {

    public static Map buildMap() {
        return new Map(GameConfiguration.LINE_COUNT, GameConfiguration.COLUMN_COUNT);
    }

    public static MobileElementManager buildInitMobile(Map map, Player player, Serveur serveur, Client client) {
        Stock stock = new Stock();
        // Initialiser le stock avec des ingrédients de départ ici
        // Cela pourrait nécessiter d'avoir accès à une ListeIngredient ou à une méthode d'initialisation
        ListeIngredient listeIngredient = new ListeIngredient(); // Assurez-vous que cette liste est correctement initialisée
        new MenuElementManager(stock, listeIngredient).initialiserStockAvecIngrédientsDeDépart();

        MobileElementManager manager = new MobileElementManager(map, player, serveur, client, stock);
        initializeGame(map, manager, serveur);
        return manager;
    }

    // Modification pour inclure Serveur comme paramètre et l'utiliser pour l'initialisation
    private static void initializeGame(Map map, MobileElementManager manager, Serveur serveur) {
        Block block = map.getBlock(GameConfiguration.LINE_COUNT / 2, GameConfiguration.COLUMN_COUNT / 2);
        
        // Mettre à jour la position du serveur au lieu de créer une nouvelle instance
        serveur.setPosition(block);        
    }
}
