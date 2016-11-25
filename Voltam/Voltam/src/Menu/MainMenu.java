package Menu;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import Partie.Monde;
import Partie.Terrain;
import Partie.Vague;
import Utilitaire.SuperPlateau;

public class MainMenu{
	
	public  static int HAUTEUR = 10;
	public  static int LONGUEUR = 20;
	
	static String[] imagesjeu={"ciel.png","cielnuageux.png","oiseaux.png","terre.png","hero.png","avionNazi.png","tankNazi.png",
								"fantomeKKK.png","membreKKK.png","bombeTerro.png","terrorist.png","maison1.png","maison2.png","maison3.png",
								"sable.png","bitume.png","usine.png","palmier.png",/*19*/"0.png","1.png","2.png","3.png","4.png","5.png",
								/*25*/"6.png","7.png","8.png","9.png","be.png","st.png",/*31*/"coeur.png", "obusNazi.png","play.png","quit.png"};
	
	SuperPlateau s;
	Terrain t;
	Monde m;
	Vague v;
	int[] coordonnePlay=new int[2];
	int[] coordonneQuit=new int[2];
	
	
	public MainMenu(int meilleurScore){
		definirTaille();
		t = new Terrain( HAUTEUR , LONGUEUR,meilleurScore) ;
		s=new SuperPlateau(imagesjeu, HAUTEUR , LONGUEUR);
		m=new Monde(t,s);
		v=new Vague(m);
		coordonnePlay[0]=m.terrain.getTableau().length/2;
		coordonnePlay[1]=(m.terrain.getTableau()[0].length/2) -2 ;
		coordonneQuit[0]=m.terrain.getTableau().length/2;
		coordonneQuit[1]=(m.terrain.getTableau()[0].length/2) ;
		m.refresh(ajouterBoutons());
	}
	public int[][] ajouterBoutons(){
		int[][] tab=m.terrain.getJeu();
		for(int l =0 ; l<tab.length; l++){
			for(int c = 0 ; c<tab[0].length; c++){
				if( l==coordonnePlay[0] && c==coordonnePlay[1] ){
					tab[l][c]=33;
				}
				if( l== coordonneQuit[0] &&  c==coordonneQuit[1] ){
					tab[l][c]=34;
				}
			}
		}
		return tab;
	}
	public void scroll(){
		v.shift(1);
	}
	
	public int waitChoice(){
		int choix=0;
		int x=0;
		int y=0;
		do{
			v.shift(1,false);
			m.refresh(ajouterBoutons());
			InputEvent event=s.waitEvent(100);
			if(event !=null ){
				x=s.getX((MouseEvent) event);
				y=s.getY((MouseEvent) event);
			}
			if( x==coordonnePlay[0] && y==coordonnePlay[1]){
				choix=1;
			}else{
				if(( x==coordonneQuit[0] || y==coordonneQuit[1])){
					choix=2;
				}
			}
			
		}while( choix<1 || choix>2);
		m.close();
		return choix;
	}
	
	public void definirTaille(){
		HAUTEUR = Toolkit.getDefaultToolkit().getScreenSize().height / 64;
		LONGUEUR = Toolkit.getDefaultToolkit().getScreenSize().width / 64;
	}
}
