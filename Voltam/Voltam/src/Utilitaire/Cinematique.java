package Utilitaire;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Cinematique extends JFrame {
	String[] images ={"cinematique1.png","cinematique2.png","cinematique3.png","cinematique4.png"};
	
	public Cinematique(){
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		this.setUndecorated(true);
		this.setVisible(true);
	}
	private BufferedImage getImage(String filename) {
		// This time, you can use an InputStream to load
		try {
		        // Grab the InputStream for the image.                    
		        //InputStream in = getClass().getResourceAsStream(filename);
		        java.net.URL imageURL = ClassLoader.getSystemResource(filename);
		    // Then read it in.
		    return ImageIO.read(imageURL);
		} catch (IOException e) {
		    System.out.println("L'image n'a pu être chargé.");
		    //System.exit(1);
		}
		    return null;
		}
	
	public void defiler(){
		ImagePanel panel=null;
		for(int i =0;i<images.length;i++){
			
			BufferedImage img = getImage(images[i]);
			panel = new ImagePanel(img) ;
			
			if(panel != null){
				
				this.add(panel);
				panel.repaint();
				
			}
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.dispose();
	}
	
	
	public static void main(String[] args){
		Cinematique cin = new Cinematique();
		cin.defiler();
	}
}
