package Personnage;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import Terrain.Bonus;
import Terrain.Coordonnees;

public class Personnage {
	
	private Coordonnees coordonnees;
	private int nbVies;
	ArrayList<Bonus> bonus;
	private String representation;
	
	public Personnage(){
		setNbVies(3);
		representation = "P";
	}

	public Coordonnees getCoordonnees() {
		return coordonnees;
	}

	public void setCoordonnees(Coordonnees coordonnees) {
		this.coordonnees = coordonnees;
	}
	public void setAbscisse(int abs){
		this.coordonnees.setAbscisse(abs);
	}
	public int getAbscisse(){
		return this.coordonnees.getAbscisse();
	}
	public void setOrdonnee(int ord){
		this.coordonnees.setOrdonnee(ord);
	}
	public int getOrdonnee(){
		return this.coordonnees.getOrdonnee();
	}

	public String getRepresentation() {
		return representation;
	}

	public void setRepresentation(String representation) {
		this.representation = representation;
	}

	public int getNbVies() {
		return nbVies;
	}

	public void setNbVies(int nbVies) {
		this.nbVies = nbVies;
	}
}
