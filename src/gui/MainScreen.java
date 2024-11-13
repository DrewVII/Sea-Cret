package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class MainScreen extends JPanel {
    private static final long serialVersionUID = 1L;

    private JButton playButton;
    private JButton exitButton;
    private BufferedImage behindTheScene;
    private int gameState = 0; // 0 = mainScreen, 1 = gameScreen, 2 = exit

    public MainScreen() {
        playButton = new JButton("Jouer");
        exitButton = new JButton("Quitter");
        GridBagConstraints griddy = new GridBagConstraints();

        try {
            behindTheScene = ImageIO.read(new FileInputStream("src/image/wallpaper.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        setLayout(new GridBagLayout());
        griddy.gridx = 0;
        griddy.gridy = 0;
        griddy.gridwidth = 1;
        add(playButton, griddy);

        griddy.gridy++;
        add(exitButton, griddy);

        setBackground(Color.WHITE);
        playButton.addActionListener(e -> gameState = 1);
        exitButton.addActionListener(e -> gameState = 2);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(behindTheScene, 0, 0, this.getWidth(), this.getHeight(), null);
    }

    public int getGameState() {
        return gameState;
    }
}
