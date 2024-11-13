package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import player.Player;




public class InfoPanel extends JPanel{  
	private static final long serialVersionUID = 1L;
	
	private Font font = new Font(Font.MONOSPACED, Font.BOLD, 20);
	
	private JLabel argentLabel;
	private JLabel nivLabel;
	private JLabel reputationLabel;
	private Player joueur;
	


public InfoPanel(Player joueur) {
	this.joueur = joueur;
	argentLabel  = new JLabel ("Argent : "+joueur.getArgent());
	nivLabel  = new JLabel("Niveau : "+joueur.getLvlRestaurant());
	reputationLabel = new JLabel("Reputation : "+joueur.getReputation());
	
	setBackground(Color.BLACK);
	setLayout(new GridLayout(1,2));
	
	argentLabel.setForeground(Color.WHITE);
	
	nivLabel.setForeground(Color.WHITE);
	
	reputationLabel.setForeground(Color.WHITE);
	
	add(argentLabel, BorderLayout.WEST);
	add(nivLabel, BorderLayout.EAST);
	add(reputationLabel,BorderLayout.NORTH);
}
/**
 * Méthode qui retourne le label argentLabel.
 * @return argentLabel JLabel
 */
public JLabel getArgentLabel() {
	return argentLabel;
}

/**
 * Méthode qui modifie le label argentLabel.
 * @param argentLabel JLabel
 */
public void setArgentLabel(JLabel argentLabel) {
	this.argentLabel = argentLabel;
}

/**
 * Méthode qui retourne le label nivLabel.
 * @return nivLabel JLabel
 */
public JLabel getNivLabel() {
	return nivLabel;
}
public JLabel getReputationLabel() {
	return reputationLabel;
}
public void setReputationLabel(JLabel reputationLabel) {
	this.reputationLabel = reputationLabel;
}
/**
 * Méthode qui modifie le label nivLabel.
 * @param nivLabel JLabel
 */
public void setNivLabel(JLabel nivLabel) {
	this.nivLabel = nivLabel;
}
public void updateInfo() {
    argentLabel.setText("Argent : " + joueur.getArgent());
    nivLabel.setText("Niveau : " + joueur.getLvlRestaurant());
    reputationLabel.setText("Reputation : " + joueur.getReputation());
    revalidate();
    repaint();
}
}
