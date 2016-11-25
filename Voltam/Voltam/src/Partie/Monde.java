package Partie;
import java.awt.Toolkit;

import Utilitaire.Deplacement;
import Utilitaire.SuperPlateau;

public class Monde {
	public  static int HAUTEUR = 10;
	public  static int LONGUEUR = 20;
	static String[] imagesjeu={"ciel.png","cielnuageux.png","oiseaux.png","terre.png","hero.png","avionNazi.png","tankNazi.png",
								"fantomeKKK.png","membreKKK.png","bombeTerro.png","terrorist.png","maison1.png","maison2.png","maison3.png",
								"sable.png","bitume.png","usine.png","palmier.png",/*19*/"0.png","1.png","2.png","3.png","4.png","5.png",
								/*25*/"6.png","7.png","8.png","9.png",/*29*/"be.png",/*30*/"st.png",/*31*/"coeur.png", "obusNazi.png"};
	
	public Terrain terrain;
	private SuperPlateau p;
	boolean abandon;
	Deplacement deplacement ;

	
	
	public Monde(int meilleurScore){
		definirTaille();
		terrain = new Terrain( HAUTEUR - 1 , LONGUEUR, meilleurScore) ;
		//setP(new SuperPlateau(imagesjeu, HAUTEUR , LONGUEUR));
		//getP().setJeu(terrain.getJeu());
		deplacement = new Deplacement(this);
		
	}
	public Monde(Terrain t, SuperPlateau s){
		terrain = t;
		setP(s);
	}
	public void definirTaille(){
		HAUTEUR = Toolkit.getDefaultToolkit().getScreenSize().height / 64;
		LONGUEUR = Toolkit.getDefaultToolkit().getScreenSize().width / 64;
	}
	public void refresh(){
		getP().setJeu(terrain.bs.getJeu(terrain.getJeu()));
		getP().affichage();
	}
	public void refresh(int[][] tab){
		
			getP().setJeu(tab);
			getP().affichage();
		
	}
	public void close(){
		getP().close();
	}
	public SuperPlateau getP() {
		return p;
	}
	public void setP(SuperPlateau p) {
		this.p = p;
	}
}
