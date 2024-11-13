package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import engine.menu.Ingredient;
import engine.process.MobileElementManager;

public class ActionZone extends JPanel {
    private static final long serialVersionUID = 1L;
    
    private JButton staff;
    private JButton stock;
    private JButton restaurant;
    private JButton info;
    
    private ShowStaff staffShower;
    private ShowStock stockShower;
    private ShowClient clientShower;
    private ShowInfo infoShower;
    
    private int option2;
    private int option3;
    
    private BufferedImage sun;
    
    private CardLayout cardLayout;
    
    private Object[] options1 = {"Fermer", "Niveau 2", "Niveau 3"};
    private Object[] options4 = {"Oui", "Non"};
	private MobileElementManager manager;
	
	public ActionZone(MobileElementManager manager) {
		this.manager = manager;
		
		staff = new JButton("Staff");
		stock = new JButton("Stock");
		restaurant = new JButton("Restaurant");
		info = new JButton("");
		
		setBackground(Color.WHITE);
		setLayout(new GridLayout(4,1));
		
		add(staff);
		add(stock);
		add(restaurant);
		add(info);
		
		staffShower = new ShowStaff();
		stockShower = new ShowStock();
		clientShower = new ShowClient();
		infoShower = new ShowInfo();
		
		staff.addActionListener(staffShower);
		stock.addActionListener(stockShower);
		restaurant.addActionListener(clientShower);
		info.addActionListener(infoShower);
		
		try {
				sun = ImageIO.read((new FileInputStream("src/image/sun.png")));
			    info.setIcon(new ImageIcon(sun));
			    info.setMargin(new Insets(0, 0, 0, 0));
			    info.setBackground(Color.BLACK);
			    info.setBorder(null);
		} catch (Exception ex) {
			    System.out.println(ex);
		}
	}
	
	public JButton getStaff() {
		return staff;
	}
	
	public JButton getStock() {
		return stock;
	}
	
	
	public JButton getRestaurant() {
		return restaurant;
	}
	
	
	public JButton getInfo() {
		return info;
	}
	
	private class ShowStaff implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			JOptionPane.showMessageDialog(null, "Nombre de serveurs : " + manager.getServeurs().size());
		}
	}
	
	// A completer 
	 private class ShowInfo implements ActionListener {
	        public void actionPerformed(ActionEvent event) {
	            JOptionPane.showMessageDialog(null, "Temps restant avant la fin : " + manager.getJourneyTime(), "Jour "+manager.getCalendrier().getJour(), JOptionPane.INFORMATION_MESSAGE);
	            option3 = JOptionPane.showOptionDialog(null, 
	                    "Voulez-vous sauvegarder?", 
	                    "Point de sauvegarde", 
	                    JOptionPane.YES_NO_CANCEL_OPTION,
	                    JOptionPane.PLAIN_MESSAGE,
	                    null, 
	                    options4, 
	                    null);
	            
	            switch(option3) {
	                case 1:
	                    if(manager.getPlayer().upgradeRestaurantLvl2() == true) {
	                        manager.getPlayer().upgradeRestaurantLvl2();
	                    }
	                    else {
	                        JOptionPane.showMessageDialog(null, "Les conditions ne sont pas encore rencontrées", "Erreur", JOptionPane.ERROR_MESSAGE);
	                    }
	                ;
	                
	                case 2:
	                    if(manager.getPlayer().upgradeRestaurantLvl3() == true) {
	                        manager.getPlayer().upgradeRestaurantLvl3();
	                    }
	                    else {
	                        JOptionPane.showMessageDialog(null, "Les conditions ne sont pas encore rencontrées", "Erreur", JOptionPane.ERROR_MESSAGE);
	                    }
	                ;
	                
	                default:
	                    System.out.println("Pass");
	            }
	        }
	    }
	
	private class ShowClient implements ActionListener {
	    public void actionPerformed(ActionEvent event) {
	        JOptionPane.showMessageDialog(null, "Nombre de clients : " + manager.getClients().size());
	        int option2 = JOptionPane.showOptionDialog(null, 
	                "Voulez-vous améliorer le restaurant?\nNiveau actuel : "+manager.getPlayer().getLvlRestaurant(), 
	                "Amelioration du restaurant", 
	                JOptionPane.YES_NO_CANCEL_OPTION,
	                JOptionPane.PLAIN_MESSAGE,
	                null, 
	                options1, 
	                null);
	        
	        switch(option2) {
	            case 1: // Option for level 2 upgrade
	                if(manager.getPlayer().upgradeRestaurantLvl2()) {
	                    JOptionPane.showMessageDialog(null, "Le restaurant a été mis à niveau vers le niveau 2", "Mise à jour réussie", JOptionPane.INFORMATION_MESSAGE);
	                } else {
	                    JOptionPane.showMessageDialog(null, "Les conditions ne sont pas encore rencontrées", "Erreur", JOptionPane.ERROR_MESSAGE);
	                }
	                break; // Break to avoid falling through

	            case 2: // Option for level 3 upgrade
	                if(manager.getPlayer().upgradeRestaurantLvl3()) {
	                    JOptionPane.showMessageDialog(null, "Le restaurant a été mis à niveau vers le niveau 3", "Mise à jour réussie", JOptionPane.INFORMATION_MESSAGE);
	                } else {
	                    JOptionPane.showMessageDialog(null, "Les conditions ne sont pas encore rencontrées", "Erreur", JOptionPane.ERROR_MESSAGE);
	                }
	                break; // Break to avoid falling through

	            default:
	                System.out.println("Pass");
	                break; // Ensure default case has a break as well
	        }
	    }
	}

	// A completer 
	private class ShowStock implements ActionListener {
	    public void actionPerformed(ActionEvent event) {
	        StringBuilder stockInfo = new StringBuilder();
	        for (Ingredient ingredient : manager.getMenuManager().getListeIngredient().getIngredientList()) {
	            int quantite = manager.getStock().getQuantite(ingredient);
	            stockInfo.append(ingredient.getNom()).append(" : ").append(quantite).append(" unités\n");
	        }

	        // Afficher les informations actuelles du stock
	        JOptionPane.showMessageDialog(null, stockInfo.toString(), "Stock Actuel", JOptionPane.INFORMATION_MESSAGE);

	        // Sélectionner un ingrédient pour l'achat
	        String nomIngredient = JOptionPane.showInputDialog("Entrez le nom de l'ingrédient à acheter:");
	        Ingredient ingredientAcheter = manager.getMenuManager().getListeIngredient().getIngredientList().stream()
	                .filter(ingredient -> ingredient.getNom().equals(nomIngredient))
	                .findFirst()
	                .orElse(null);

	        if (ingredientAcheter != null) {
	            // Saisir la quantité à acheter
	            String quantiteAcheterStr = JOptionPane.showInputDialog("Entrez la quantité à acheter pour " + nomIngredient + ":");
	            int quantiteAcheter;
	            try {
	                quantiteAcheter = Integer.parseInt(quantiteAcheterStr);
	            } catch (NumberFormatException e) {
	                JOptionPane.showMessageDialog(null, "Quantité invalide", "Erreur", JOptionPane.ERROR_MESSAGE);
	                return;
	            }

	            // Ici, vous pouvez ajouter la logique pour déduire l'argent du joueur et mettre à jour le stock
	            // Par exemple, supposons que chaque unité coûte 5 unités de monnaie du jeu et que le joueur a suffisamment d'argent
	            int coutTotal = quantiteAcheter * 5; // Changez ce coût selon votre jeu
	            if (manager.getPlayer().getArgent() >= coutTotal) {
	                manager.getStock().acheterIngredient(ingredientAcheter, quantiteAcheter);
	                manager.getPlayer().setArgent(manager.getPlayer().getArgent() - coutTotal);
	                JOptionPane.showMessageDialog(null, "Achat réussi de " + quantiteAcheter + " " + nomIngredient, "Achat réussi", JOptionPane.INFORMATION_MESSAGE);
	            } else {
	                JOptionPane.showMessageDialog(null, "Pas assez d'argent pour cet achat.", "Achat échoué", JOptionPane.ERROR_MESSAGE);
	            }
	        } else {
	            JOptionPane.showMessageDialog(null, "Ingrédient non trouvé", "Erreur", JOptionPane.ERROR_MESSAGE);
	        }
	    }
	}
	
}