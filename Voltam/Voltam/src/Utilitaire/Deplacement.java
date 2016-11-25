package Utilitaire;
import java.awt.event.KeyEvent;

import Partie.Monde;
import Personnage.Personnage;


public class Deplacement {

	private Monde monde;
	private Personnage perso;
	
	
	
	public Deplacement(){
		
	}
	
	public Deplacement(Monde m){
		monde = m;
		perso= monde.terrain.getPerso() ;
	}
	
	
	private void deplacementHaut(){
		monde.terrain.getPerso().setAbscisse(monde.terrain.getPerso().getAbscisse()-1);
	}
	private void deplacementBas(){
		monde.terrain.getPerso().setAbscisse(monde.terrain.getPerso().getAbscisse()+1);
	}
	public void deplacement(int temps){
		KeyEvent event=(KeyEvent) monde.getP().waitKeyEvent(temps);
		
		
		if(event != null){
			Personnage tmp=monde.terrain.getTableau()[monde.terrain.getPerso().getAbscisse()][monde.terrain.getPerso().getOrdonnee()].getPerso();
			monde.terrain.getTableau()[monde.terrain.getPerso().getAbscisse()][monde.terrain.getPerso().getOrdonnee()].setPerso(null);
			if(event.getKeyCode() == KeyEvent.VK_UP){
				if( monde.terrain.getPerso().getAbscisse() > 0 && monde.terrain.getTableau()[perso.getAbscisse()-1][perso.getOrdonnee()].isNaviguable()){
					deplacementHaut();
				}
			}else{
				if(event.getKeyCode() == KeyEvent.VK_DOWN){
					if( monde.terrain.getPerso().getAbscisse() < monde.terrain.getTableau()[0].length-1 && monde.terrain.getTableau()[perso.getAbscisse()+1][perso.getOrdonnee()].isNaviguable() ){
						deplacementBas();
					}
				}
			}
			monde.terrain.getTableau()[monde.terrain.getPerso().getAbscisse()][monde.terrain.getPerso().getOrdonnee()].setPerso(tmp);
		}
		
	
	
			
		
	}
}

