package Utilitaire;
import java.awt.Dimension;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class SuperPlateau {
	Plateau test;
	
	public SuperPlateau(String[] gifs, int lignes, int colonnes){
		this.test = new Plateau(gifs, lignes, colonnes) ;
	}
	SuperPlateau(String[] gifs, int lignes, int colonnes,boolean textArea){
		this.test = new Plateau(gifs, lignes , colonnes,textArea) ;
	}
	
	
	public void affichage(){
		this.test.affichage();
		
	}
	public void affichage(Dimension dim){
		this.test.affichage(dim);
	}
	public void println(String message){
		this.test.println(message);
	}
	public InputEvent waitEvent() {
		return test.waitEvent();
	}
	public InputEvent waitEvent(int timeout){
		return test.waitEvent(timeout);
	}
	public int getX(MouseEvent event) {
		return test.getX(event) ; 
	}
	public void setRezisable(boolean resizable){
		this.test.setResizable(resizable);
	}
	public int getY(MouseEvent event) { 	
		return test.getY(event) ;
	}
	public int[][] getJeu(){
		return this.test.getJeu();
	}
	public void setJeu(int[][] tab){
		this.test.setJeu(tab);
	}

	public void close() {
		test.close();
	}
	public void setPreferedSize(int largeur,int longueur){
		this.test.setPreferedSize(largeur, longueur);
		
	}
	public KeyEvent waitKeyEvent() {
		
		return this.test.waitKeyEvent();
		
	}
public KeyEvent waitKeyEvent(int timeout) {
		
		return this.test.waitKeyEvent(timeout);
		
	}
	
}
	

