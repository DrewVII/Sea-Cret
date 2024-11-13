package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

import javax.imageio.ImageIO;

import config.GameConfiguration;
import engine.map.Map;
import engine.mobile.Client;
import engine.mobile.Cuisinier;
import engine.mobile.Serveur;
import engine.outil.Chaise;
import engine.outil.Table;
import engine.process.MobileElementManager;

public class PaintStrategy {

    private BufferedImage sol;
    private BufferedImage serveurimg;
    private BufferedImage cuisine;
    private BufferedImage tableimg;
    private BufferedImage[] clientimg;
    private BufferedImage stockimg;
    private BufferedImage fumerimg;
    private BufferedImage invisible;
    private BufferedImage chaiseD;
    private BufferedImage chaiseG;
    private BufferedImage cuisinierimg;
    private Random random;
    private MobileElementManager manager;
    private HashMap<Client, BufferedImage> clientImageMap = new HashMap<>();

    public PaintStrategy(MobileElementManager manager) {
        this.manager = manager;
        random = new Random();
        try {
            sol = ImageIO.read(new FileInputStream("src/image/sol.png"));
            serveurimg = ImageIO.read(new FileInputStream("src/image/serveur.png"));
            cuisine = ImageIO.read(new FileInputStream("src/image/cuisine.png"));
            tableimg = ImageIO.read(new FileInputStream("src/image/table.png"));
            loadClientImages();
            stockimg = ImageIO.read(new FileInputStream("src/image/stock.png"));
            fumerimg = ImageIO.read(new FileInputStream("src/image/fumee.png"));
            invisible = ImageIO.read(new FileInputStream("src/image/invisible.png"));
            chaiseD = ImageIO.read(new FileInputStream("src/image/droite.png"));
            chaiseG = ImageIO.read(new FileInputStream("src/image/gauche.png"));
            cuisinierimg = ImageIO.read(new FileInputStream("src/image/cuisinier.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void loadClientImages() {
        try {
            clientimg = new BufferedImage[]{
                    ImageIO.read(new FileInputStream("src/image/client1.png")),
                    ImageIO.read(new FileInputStream("src/image/client2.png")),
                    ImageIO.read(new FileInputStream("src/image/client3.png")),
                    ImageIO.read(new FileInputStream("src/image/client4.png")),
                    ImageIO.read(new FileInputStream("src/image/client5.png")),
                    ImageIO.read(new FileInputStream("src/image/client6.png")),
                    ImageIO.read(new FileInputStream("src/image/client7.png")),
                    ImageIO.read(new FileInputStream("src/image/client8.png")),
                    ImageIO.read(new FileInputStream("src/image/client9.png"))
                };
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	public void paint(Map map, Graphics graphics) {
        int blockSize = GameConfiguration.BLOCK_SIZE;

        BufferedImage image = sol;

        for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
            for (int columnIndex = 0; columnIndex < map.getColumnCount(); columnIndex++) {

                graphics.setColor(Color.RED);
                Graphics2D g2 = (Graphics2D) graphics;

                g2.drawImage(image,columnIndex*blockSize,lineIndex*blockSize, blockSize, blockSize, null);
                
                if ((lineIndex >=0 && lineIndex <=7) && (columnIndex >= 0 && columnIndex <= 6)) {
                    g2.drawImage(cuisine, columnIndex * blockSize, lineIndex * blockSize, blockSize, blockSize, null);
                }
                
                if ((lineIndex >=8 && lineIndex <=13) && (columnIndex >= 0 && columnIndex <= 6)) {
                    g2.drawImage(stockimg, columnIndex * blockSize, lineIndex * blockSize, blockSize, blockSize, null);
                }
                
                ///////////////LVL 2
                if ((lineIndex >=2 && lineIndex <=4) && (columnIndex >= 1 && columnIndex <= 19)) {
                    g2.drawImage(fumerimg, columnIndex * blockSize, lineIndex * blockSize, blockSize, blockSize, null);
                }
                ////////////////LVL3
                if ((lineIndex >=0 && lineIndex <=1) && (columnIndex >= 0 && columnIndex <= 23)) {
                    g2.drawImage(fumerimg, columnIndex * blockSize, lineIndex * blockSize, blockSize, blockSize, null);
                }
                ////////////////LVL2
                if ((lineIndex >=5 && lineIndex <=12) && (columnIndex >= 1 && columnIndex <= 2)) {
                    g2.drawImage(fumerimg, columnIndex * blockSize, lineIndex * blockSize, blockSize, blockSize, null);
                }
                ////////////////LVL3
                if ((lineIndex >=2 && lineIndex <=13) && (columnIndex == 0 )) {
                    g2.drawImage(fumerimg, columnIndex * blockSize, lineIndex * blockSize, blockSize, blockSize, null);
                }
                ///////////////////LVL2
                if ((lineIndex >=11 && lineIndex <=12) && (columnIndex >= 3 && columnIndex <= 19)) {
                    g2.drawImage(fumerimg, columnIndex * blockSize, lineIndex * blockSize, blockSize, blockSize, null);
                }
                /////////////////LVL3
                if ((lineIndex ==13 ) && (columnIndex >= 1 && columnIndex <= 23)) {
                    g2.drawImage(fumerimg, columnIndex * blockSize, lineIndex * blockSize, blockSize, blockSize, null);
                }
                //////////LVL 2
                
                if ((lineIndex >=5 && lineIndex <=10) && (columnIndex >= 16 && columnIndex <= 19)) {
                    g2.drawImage(fumerimg, columnIndex * blockSize, lineIndex * blockSize, blockSize, blockSize, null);
                }
                /////////// LVL 3
                if ((lineIndex >=2 && lineIndex <=12) && (columnIndex >= 20 && columnIndex <= 23)) {
                    g2.drawImage(fumerimg, columnIndex * blockSize, lineIndex * blockSize, blockSize, blockSize, null);
                }
                
              //ChaiseGauche
                g2.drawImage(chaiseG,8*blockSize,6*blockSize, blockSize, blockSize, null);
                g2.drawImage(chaiseG,8*blockSize,9*blockSize, blockSize, blockSize, null);
                g2.drawImage(chaiseG,13*blockSize,6*blockSize, blockSize, blockSize, null);
                g2.drawImage(chaiseG,13*blockSize,9*blockSize, blockSize, blockSize, null);
                
                //ChaiseDroit
                g2.drawImage(chaiseD,10*blockSize,6*blockSize, blockSize, blockSize, null);
                g2.drawImage(chaiseD,10*blockSize,9*blockSize, blockSize, blockSize, null);
                g2.drawImage(chaiseD,15*blockSize,6*blockSize, blockSize, blockSize, null);
                g2.drawImage(chaiseD,15*blockSize,9*blockSize, blockSize, blockSize, null);}
        }
    }
	   public void replaceLvl2(MobileElementManager manager, Graphics graphics,Map map) {
		   int blockSize = GameConfiguration.BLOCK_SIZE;
		   for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
	            for (int columnIndex = 0; columnIndex < map.getColumnCount(); columnIndex++) {
	            	Graphics2D g2 = (Graphics2D) graphics;
	            	
		  
			   ///////////////LVL 2
               if ((lineIndex >=2 && lineIndex <=4 ) && (columnIndex >= 1 && columnIndex <= 6)) {
                   g2.drawImage(cuisine, columnIndex * blockSize, lineIndex * blockSize, blockSize, blockSize, null);
               }
               if ((lineIndex >=2 && lineIndex <=4 ) && (columnIndex >= 7 && columnIndex <= 19)) {
                   g2.drawImage(sol, columnIndex * blockSize, lineIndex * blockSize, blockSize, blockSize, null);
               }
               
               
               ////////////////LVL2
               if ((lineIndex >=2 && lineIndex <=12) && (columnIndex >= 16 && columnIndex <= 19)) {
                   g2.drawImage(sol, columnIndex * blockSize, lineIndex * blockSize, blockSize, blockSize, null);
               }
              
               ///////////////////LVL2
               if ((lineIndex >=11 && lineIndex <=12) && (columnIndex >= 7 && columnIndex <= 15)) {
                   g2.drawImage(sol, columnIndex * blockSize, lineIndex * blockSize, blockSize, blockSize, null);
               }
              
               //////////LVL 2
               
               if ((lineIndex >=11 && lineIndex <=12) && (columnIndex >= 1 && columnIndex <= 6)) {
                   g2.drawImage(stockimg, columnIndex * blockSize, lineIndex * blockSize, blockSize, blockSize, null);
               }
               
               if ((lineIndex >=8 && lineIndex <=10) && (columnIndex >= 1 && columnIndex <= 2)) {
                   g2.drawImage(stockimg, columnIndex * blockSize, lineIndex * blockSize, blockSize, blockSize, null);
               }
             
               if ((lineIndex >=5 && lineIndex <=7) && (columnIndex >= 1 && columnIndex <= 2)) {
                   g2.drawImage(cuisine, columnIndex * blockSize, lineIndex * blockSize, blockSize, blockSize, null);
               }
               
               g2.drawImage(chaiseG,8*blockSize,3*blockSize, blockSize, blockSize, null);
               g2.drawImage(chaiseG,13*blockSize,3*blockSize, blockSize, blockSize, null);
               
               g2.drawImage(chaiseD,10*blockSize,3*blockSize, blockSize, blockSize, null);
               g2.drawImage(chaiseD,15*blockSize,3*blockSize, blockSize, blockSize, null);
               
               g2.drawImage(tableimg,9*blockSize,3*blockSize, blockSize, blockSize, null);
               g2.drawImage(tableimg,14*blockSize,3*blockSize, blockSize, blockSize, null);
			   
		   }
	            }
		   }
	   
	   
	   public void replaceLvl3(MobileElementManager manager, Graphics graphics,Map map) {
		   int blockSize = GameConfiguration.BLOCK_SIZE;
		   for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
	            for (int columnIndex = 0; columnIndex < map.getColumnCount(); columnIndex++) {
	            	Graphics2D g2 = (Graphics2D) graphics;
	            	
	            	
	            	 if ((lineIndex >=0 && lineIndex <=7) && (columnIndex ==0)) {
	                     g2.drawImage(cuisine, columnIndex * blockSize, lineIndex * blockSize, blockSize, blockSize, null);
	                 }
	            	 if ((lineIndex >=0 && lineIndex <=1) && (columnIndex >= 0 && columnIndex <= 6)) {
	                     g2.drawImage(cuisine, columnIndex * blockSize, lineIndex * blockSize, blockSize, blockSize, null);
	                 }
	            	 if ((lineIndex >=0 && lineIndex <=1) && (columnIndex >= 7 && columnIndex <= 23)) {
	                     g2.drawImage(sol, columnIndex * blockSize, lineIndex * blockSize, blockSize, blockSize, null);
	                 }
	            	 if ((lineIndex >=2 && lineIndex <=13) && (columnIndex >= 20 && columnIndex <= 23)) {
	                     g2.drawImage(sol, columnIndex * blockSize, lineIndex * blockSize, blockSize, blockSize, null);
	                 }
	            	 if ((lineIndex ==13) && (columnIndex >= 7 && columnIndex <= 19)) {
	                     g2.drawImage(sol, columnIndex * blockSize, lineIndex * blockSize, blockSize, blockSize, null);
	                 }
	            	 if ((lineIndex ==13) && (columnIndex >= 0 && columnIndex <= 6)) {
	                     g2.drawImage(stockimg, columnIndex * blockSize, lineIndex * blockSize, blockSize, blockSize, null);
	                 }
	            	 if ((lineIndex >=8 && lineIndex <=13) && (columnIndex ==0)) {
	                     g2.drawImage(stockimg, columnIndex * blockSize, lineIndex * blockSize, blockSize, blockSize, null);
	                 }
	                 g2.drawImage(chaiseG,8*blockSize,1*blockSize, blockSize, blockSize, null);
	                 g2.drawImage(chaiseG,13*blockSize,1*blockSize, blockSize, blockSize, null);
	                 g2.drawImage(chaiseG,19*blockSize,1*blockSize, blockSize, blockSize, null);
	                 g2.drawImage(chaiseG,19*blockSize,3*blockSize, blockSize, blockSize, null);
	                 g2.drawImage(chaiseG,19*blockSize,6*blockSize, blockSize, blockSize, null);
	                 g2.drawImage(chaiseG,19*blockSize,9*blockSize, blockSize, blockSize, null);
	                 g2.drawImage(chaiseG,19*blockSize,12*blockSize, blockSize, blockSize, null);
	                 g2.drawImage(chaiseG,13*blockSize,12*blockSize, blockSize, blockSize, null);
	                 g2.drawImage(chaiseG,8*blockSize,12*blockSize, blockSize, blockSize, null);
	                 
	                 
	                 g2.drawImage(chaiseD,10*blockSize,1*blockSize, blockSize, blockSize, null);
	                 g2.drawImage(chaiseD,15*blockSize,1*blockSize, blockSize, blockSize, null);
	                 g2.drawImage(chaiseD,21*blockSize,1*blockSize, blockSize, blockSize, null);
	                 g2.drawImage(chaiseD,21*blockSize,3*blockSize, blockSize, blockSize, null);
	                 g2.drawImage(chaiseD,21*blockSize,6*blockSize, blockSize, blockSize, null);
	                 g2.drawImage(chaiseD,21*blockSize,9*blockSize, blockSize, blockSize, null);
	                 g2.drawImage(chaiseD,21*blockSize,12*blockSize, blockSize, blockSize, null);
	                 g2.drawImage(chaiseD,15*blockSize,12*blockSize, blockSize, blockSize, null);
	                 g2.drawImage(chaiseD,10*blockSize,12*blockSize, blockSize, blockSize, null);
	                 
	                 g2.drawImage(tableimg,9*blockSize,1*blockSize, blockSize, blockSize, null);
	                 g2.drawImage(tableimg,14*blockSize,1*blockSize, blockSize, blockSize, null);
	                 g2.drawImage(tableimg,20*blockSize,1*blockSize, blockSize, blockSize, null);
	                 g2.drawImage(tableimg,20*blockSize,3*blockSize, blockSize, blockSize, null);
	                 g2.drawImage(tableimg,20*blockSize,6*blockSize, blockSize, blockSize, null);
	                 g2.drawImage(tableimg,20*blockSize,9*blockSize, blockSize, blockSize, null);
	                 g2.drawImage(tableimg,20*blockSize,12*blockSize, blockSize, blockSize, null);
	                 g2.drawImage(tableimg,14*blockSize,12*blockSize, blockSize, blockSize, null);
	                 g2.drawImage(tableimg,9*blockSize,12*blockSize, blockSize, blockSize, null);
	                 
	  			   
	            }
		   }
	   }

	 private BufferedImage getClientImage(Client client) {
	        // If the client already has an image assigned, use it
	        if (!clientImageMap.containsKey(client)) {
	            // Otherwise, randomly pick an image and assign it to this client
	            BufferedImage selectedImage = clientimg[random.nextInt(clientimg.length)];
	            clientImageMap.put(client, selectedImage);
	        }
	        return clientImageMap.get(client);
	    }
	 public void removeClientImage(Client client) {
	        clientImageMap.remove(client);
	    }
	 
    public void paint(Client client, Graphics graphics) {
        Graphics2D g2 = (Graphics2D) graphics;
        BufferedImage image = getClientImage(client);
        int blockSize = GameConfiguration.BLOCK_SIZE;
        g2.drawImage(image, client.getColumn() * blockSize, client.getLine() * blockSize, blockSize, blockSize, null);
    }

    public void paint(Serveur serveur, Graphics graphics) {
        int blockSize = GameConfiguration.BLOCK_SIZE;
        Graphics2D g2 = (Graphics2D) graphics;
        g2.drawImage(serveurimg, serveur.getColumn() * blockSize, serveur.getLine() * blockSize, blockSize, blockSize, null);
    }

    public void paint(Cuisinier cuisinier, Graphics graphics) {
        int blockSize = GameConfiguration.BLOCK_SIZE;
        Graphics2D g2 = (Graphics2D) graphics;
        g2.drawImage(cuisinierimg, cuisinier.getColumn() * blockSize, cuisinier.getLine() * blockSize, blockSize, blockSize, null);
    }
    public void paint(Table table, Graphics2D graphics) {

        int blockSize = GameConfiguration.BLOCK_SIZE;
        Graphics2D g3 = (Graphics2D) graphics;

        g3.drawImage(tableimg, table.getColumn() * blockSize, table.getLine() * blockSize, blockSize, blockSize, null);
    }
    public void paint(Chaise chaise, Graphics2D graphics) {

        int blockSize = GameConfiguration.BLOCK_SIZE;
        Graphics2D g3 = (Graphics2D) graphics;

        g3.drawImage(invisible, chaise.getColumn() * blockSize, chaise.getLine() * blockSize, blockSize, blockSize, null);
    }
}
