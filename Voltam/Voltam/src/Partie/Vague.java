package Partie;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import Ennemis.AvionNazi;
import Ennemis.AvionTerroriste;
import Ennemis.CroixKKK;
import Ennemis.Ennemi;
import Ennemis.MembreKKK;
import Ennemis.ObusNazi;
import Ennemis.TankNazi;
import Ennemis.Terroriste;
import Terrain.Bitume;
import Terrain.Bonus;
import Terrain.Case;
import Terrain.Ciel;
import Terrain.Sable;
import Terrain.Terre;

public class Vague {
	
	Ennemi ennemi;
	ArrayList<Bonus> bonus;
	Monde monde;
	private int decalages = 0;
	private int espaceEntreEnnemi = 15 ;
	private int espaceEntreNouvelEnvironnement = 200 ;
	private int environnement = 3 ; //1 == nazi  || 2== KKK || 3 == Terro
	private int nbPassage = 6;
	private int scoreP =  0 ;
	public Vague(Monde m){
		monde = m;
		decalages=monde.terrain.getTableau()[0].length-3;
	}
	public void genererNouvelEnvironnement(){
		Random Rand= new Random();
		
		environnement = Rand.nextInt(3)+1 ;
		
	}
	public void genererBonus(){ //TODO
	
	}
	public void creerPassage(){
		Random rand = new Random();
		int ligne;
		do{
		ligne=rand.nextInt(monde.terrain.getTableau().length-2);
		}while( !(monde.terrain.getTableau()[ligne][monde.terrain.getTableau()[0].length-1].isEnnemi() ) );
		monde.terrain.getTableau()[ligne][monde.terrain.getTableau()[0].length-1].setEnnemi(null);
	}
	public void genererNazi(){
		for(int l = 0 ; l < monde.terrain.getTableau().length ; l++){
			for(int c = monde.terrain.getTableau()[0].length-1 ; c < monde.terrain.getTableau()[0].length ; c++){
			
				if( l == monde.terrain.getTableau().length-2 ){
						monde.terrain.getTableau()[l][c].setEnnemi(new TankNazi() ); 
				}
				if( l == monde.terrain.getTableau().length-1 ){
					monde.terrain.getTableau()[l][c] = new Case(new Bitume());
				}
			}
		}
		Random rand = new Random();
		int ligne = rand.nextInt(3);
		monde.terrain.getTableau()[ligne][monde.terrain.getTableau()[0].length-1].setEnnemi(new AvionNazi() ); 
		
		
	}
	public void genererKKK(){
		for(int l = 0 ; l < monde.terrain.getTableau().length ; l++){
			for(int c = monde.terrain.getTableau()[0].length-1 ; c < monde.terrain.getTableau()[0].length ; c++){
				monde.terrain.getTableau()[l][c].setEnnemi(new CroixKKK() ); 
				if( l == monde.terrain.getTableau().length-2 ){
						monde.terrain.getTableau()[l][c].setEnnemi(new MembreKKK() ); 
				}
				if( l == monde.terrain.getTableau().length-1 ){
					monde.terrain.getTableau()[l][c] = new Case(new Terre());
				}
			}
		}
		for (int nbTrou = 0 ;nbTrou < nbPassage; nbTrou++ ){
			creerPassage();
		}
	}
	public void genererTerroriste(){
		for(int l = 0 ; l < monde.terrain.getTableau().length ; l++){
			for(int c = monde.terrain.getTableau()[0].length-1 ; c < monde.terrain.getTableau()[0].length ; c++){
				monde.terrain.getTableau()[l][c].setEnnemi(new AvionTerroriste() ); 
				if( l == monde.terrain.getTableau().length-2 ){
						monde.terrain.getTableau()[l][c].setEnnemi(new Terroriste() ); 
				}
				if( l == monde.terrain.getTableau().length-1 ){
					monde.terrain.getTableau()[l][c] = new Case(new Sable());
				}
			}
		}
		for (int nbTrou = 0 ;nbTrou < nbPassage; nbTrou++ ){
			creerPassage();
		}
	}
	
	public void genererEnnemi(){ //TODO
		if(environnement == 1){
			genererNazi();
		}else{
			if(environnement == 2){
				genererKKK();
			}else{
				if(environnement == 3){
					genererTerroriste();
					
				}
			}
		}
		
		
	}
	
	public boolean isDropObus(){
		Random rand = new Random();
		if(rand.nextInt(100) >87){
			return true;
		}
		return false;
	}
	
	public void dropObus(){
		for(int l = 0 ; l < monde.terrain.getTableau().length ; l++){
			for(int c = 0 ; c < monde.terrain.getTableau()[0].length-1 ; c++){
				if(monde.terrain.getTableau()[l][c].getEnnemi() != null){
					if(monde.terrain.getTableau()[l][c].getEnnemi() instanceof AvionNazi){
						if(isDropObus()){
							if( (l+1 < monde.terrain.getTableau().length-2) && (monde.terrain.getTableau()[l+1][c].getEnnemi() == null ) )
							monde.terrain.getTableau()[l+1][c].setEnnemi(new ObusNazi());
						}
					}
				}
			}
		}
	}
	
	public void deplacerObus(){
		for(int c = 0 ; c < monde.terrain.getTableau()[0].length-1 ; c++){
			
			
			for(int l = monde.terrain.getTableau().length-1 ; l > 0 ; l--){
				if(monde.terrain.getTableau()[l][c].getEnnemi() != null){
					if(monde.terrain.getTableau()[l][c].getEnnemi() instanceof ObusNazi){
						
						
							
							if( (l+1 < monde.terrain.getTableau().length-1) && monde.terrain.getTableau()[l+1][c].getEnnemi() == null ){
								monde.terrain.getTableau()[l+1][c].setEnnemi(new ObusNazi());
								
							}
							monde.terrain.getTableau()[l][c].setEnnemi(null);
						
					}
				}
			}
		}
			
		
	}
	public int getScoreP(){
		return scoreP;
	}
	
	public void placerBonus(){
		if(bonus != null){
			for(int cpt=0 ; cpt < bonus.size() ; cpt++){
				monde.terrain.getTableau()[bonus.get(cpt).getCoordonnees().getAbscisse()][bonus.get(cpt).getCoordonnees().getOrdonnee()].setBonus( bonus.get(cpt) );
			}
		}
	}
	
	
	public void nouvelleDerniereColonne(){
		genererColonneVierge();
		if((decalages % espaceEntreNouvelEnvironnement) == 0 ){
			genererNouvelEnvironnement();
			
				
			
		}
		
		if( (decalages % espaceEntreEnnemi) == 0 ){
			genererEnnemi();
		}
		
		if(percuteOiseaux()){
			monde.terrain.getPerso().setNbVies(monde.terrain.getPerso().getNbVies()-1);
			 try {
		         // Open an audio input stream.
		         URL url = this.getClass().getClassLoader().getResource("oiseau.wav");
		         AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
		         // Get a sound clip resource.
		         Clip clip = AudioSystem.getClip();
		         // Open audio clip and load samples from the audio input stream.
		         clip.open(audioIn);
		         clip.start();
		      } catch (UnsupportedAudioFileException e) {
		         e.printStackTrace();
		      } catch (IOException e) {
		         e.printStackTrace();
		      } catch (LineUnavailableException e) {
		         e.printStackTrace();
		      }
		}
		
		
		if( decalages/espaceEntreEnnemi > 2){
			
			if( (presenceEnnemie())){
				
				if(eviteEnnemi()){
				
					scoreP += 1;
					 try {
				         // Open an audio input stream.
				         URL url = this.getClass().getClassLoader().getResource("success.wav");
				         AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
				         // Get a sound clip resource.
				         Clip clip = AudioSystem.getClip();
				         // Open audio clip and load samples from the audio input stream.
				         clip.open(audioIn);
				         clip.start();
				      } catch (UnsupportedAudioFileException e) {
				         e.printStackTrace();
				      } catch (IOException e) {
				         e.printStackTrace();
				      } catch (LineUnavailableException e) {
				         e.printStackTrace();
				      }
				}else{
					monde.terrain.getPerso().setNbVies(monde.terrain.getPerso().getNbVies()-1);
					 try {
				         // Open an audio input stream.
				         URL url = this.getClass().getClassLoader().getResource("ennemi.wav");
				         AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
				         // Get a sound clip resource.
				         Clip clip = AudioSystem.getClip();
				         // Open audio clip and load samples from the audio input stream.
				         clip.open(audioIn);
				         clip.start();
				      } catch (UnsupportedAudioFileException e) {
				         e.printStackTrace();
				      } catch (IOException e) {
				         e.printStackTrace();
				      } catch (LineUnavailableException e) {
				         e.printStackTrace();
				      }
				}
			}
		}
		
	}
	
	public void nouvelleDerniereColonne(boolean ennemie){
		genererColonneVierge();
		if((decalages % espaceEntreNouvelEnvironnement) == 0 ){
			genererNouvelEnvironnement();
			
				
			
		}
		if(ennemie){
			if( (decalages % espaceEntreEnnemi) == 0 ){
				genererEnnemi();
			}
		}
		if( decalages >0){
			if(decalages >  monde.terrain.getTableau().length)
			if( (decalages % espaceEntreEnnemi) == monde.terrain.getTableau().length-4){
				scoreP ++;
			}
		}
	}
	
	private void genererColonneVierge() {
		definirNombreDePassage();
		for(int l = 0 ; l < monde.terrain.getTableau().length ; l++){
			for(int c = monde.terrain.getTableau()[0].length-1 ; c < monde.terrain.getTableau()[0].length ; c++){
				monde.terrain.getTableau()[l][c] = new Case(new Ciel(false,false));
				if( l < 3 ){
					monde.terrain.getTableau()[l][c] = new Case(new Ciel());
				}
				else{
					if( l == monde.terrain.getTableau().length-1 ){
						if(environnement == 1){
							monde.terrain.getTableau()[l][c] = new Case(new Bitume());
						}
						if(environnement == 2){
							monde.terrain.getTableau()[l][c] = new Case(new Terre());
						}
						if(environnement == 3){
							monde.terrain.getTableau()[l][c] = new Case(new Sable());
						}
					}else{
						if(l == monde.terrain.getTableau().length-2 ){
							Random rand = new Random();
							int placerDecor=rand.nextInt(100);
							if(placerDecor>90){
								if( environnement == 1 ){
									monde.terrain.getTableau()[l][c] = new Case(new Ciel(false, false, false , false, true));
								}else{
									if(environnement == 2){
										monde.terrain.getTableau()[l][c] = new Case(new Ciel(false, false, true));
									}else{
										if(environnement == 3){
											monde.terrain.getTableau()[l][c] = new Case(new Ciel(false, false, false , true));
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
	public void definirNombreDePassage(){
		if(scoreP<20){
			nbPassage = 6;
		}else{
			if(scoreP<50){
				nbPassage = 5;
			}else{
				if(scoreP<75){
					nbPassage = 4;
				}else{
					if(scoreP<100){
						nbPassage = 3;
					}else{
						if(scoreP<150){
							nbPassage = 2;
						}else{
								nbPassage =1;
							
						}
					}
				}
			}
		}
	}
	public void shift(int nombreDecalage){
		while( nombreDecalage > 0 ){
			for(int l = 0 ; l < monde.terrain.getTableau().length ; l++){
				for(int c = 0 ; c < monde.terrain.getTableau()[0].length-1 ; c++){
					monde.terrain.getTableau()[l][c] = monde.terrain.getTableau()[l][c+1];
					
				}
			}
			dropObus();
			if(decalages%3 == 0){
				deplacerObus();
			}
			nouvelleDerniereColonne();
			decalages += 1 ;
			nombreDecalage -= 1 ;
		}
		
	}
	public void shift(int nombreDecalage, boolean ennemie){
		while( nombreDecalage > 0 ){
			for(int l = 0 ; l < monde.terrain.getTableau().length ; l++){
				for(int c = 0 ; c < monde.terrain.getTableau()[0].length-1 ; c++){
					monde.terrain.getTableau()[l][c] = monde.terrain.getTableau()[l][c+1];
					
				}
			}
			
			nouvelleDerniereColonne(ennemie);
			decalages += 1 ;
			nombreDecalage -= 1 ;
		}
	}
	
	public boolean presenceEnnemie(){
		boolean ennemi=false;
		for(int l=0; l<monde.terrain.getTableau().length;l++){
			if(monde.terrain.getTableau()[l][3].getEnnemi() != null){
				return true;
			}
		}
		return ennemi;
	}
	
	public boolean eviteEnnemi(){
		boolean correcte=true;
		
		if(monde.terrain.getTableau()[monde.terrain.getPerso().getAbscisse()][monde.terrain.getPerso().getOrdonnee()].getEnnemi() !=null  )  {
			return false;
		}
			
		
		return correcte;
	}
	public boolean percuteOiseaux(){
		return( ( (Ciel) (monde.terrain.getTableau()[monde.terrain.getPerso().getAbscisse()][monde.terrain.getPerso().getOrdonnee()].getElement())).isOiseaux());
			
		
	}
	
}
