package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import config.GameConfiguration;
import engine.map.Block;
import engine.map.Map;
import engine.mobile.Client;
import engine.mobile.Serveur;
import engine.process.GameBuilder;
import engine.process.MobileElementManager;
import player.Player;

public class MainGUI extends JFrame implements Runnable {
    private static final long serialVersionUID = 1L;

    private Map map;
    private Player player;
    private Block positionInit = new Block(1, 1);
    private Block positionClient = new Block(10, 10);
    private Serveur serveur = new Serveur(1, 1, positionInit);
    private final static Dimension preferredSize = new Dimension(GameConfiguration.WINDOW_WIDTH, GameConfiguration.WINDOW_HEIGHT);

    private MobileElementManager manager;
    private GameDisplay dashboard;
    private InfoPanel info;
    private ActionZone actionZone;
    private MainScreen mainTitle;

    private BufferedImage icon;
    private Client client = new Client(positionClient, 20, 0, serveur, player);

    public MainGUI(String title) {
        super(title);
        init();
    }

    private void init() {
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        map = GameBuilder.buildMap();
        manager = GameBuilder.buildInitMobile(map, player, serveur, client);
        dashboard = new GameDisplay(map, manager);
        info = new InfoPanel(manager.getPlayer());
        actionZone = new ActionZone(manager);
        mainTitle = new MainScreen();

        try {
            icon = ImageIO.read(new FileInputStream("src/image/seacret_de_la_mer.jpg"));
        } catch (Exception ex) {
            System.out.println(ex);
        }

        contentPane.add(mainTitle, BorderLayout.CENTER);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(preferredSize);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setIconImage(icon);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(GameConfiguration.GAME_SPEED);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            switch (mainTitle.getGameState()) {
                case 1:
                    showGameScreen();
                    break;
                case 2:
                    System.exit(0);
                    break;
                default:
                    break;
            }
            if (mainTitle.getGameState() == 1) {
                manager.nextRound();
                dashboard.repaint();
                info.updateInfo();
                actionZone.repaint();
            }
        }
    }

    private void showGameScreen() {
        getContentPane().removeAll();
        getContentPane().add(dashboard, BorderLayout.CENTER);
        getContentPane().add(info, BorderLayout.NORTH);
        getContentPane().add(actionZone, BorderLayout.EAST);
        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        MainGUI mainGUI = new MainGUI("Game Title");
        new Thread(mainGUI).start();
    }
}
