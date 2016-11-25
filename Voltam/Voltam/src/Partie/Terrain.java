package Partie;
import Ennemis.AvionNazi;
import Ennemis.AvionTerroriste;
import Ennemis.CroixKKK;
import Ennemis.Hero;
import Ennemis.MembreKKK;
import Ennemis.ObusNazi;
import Ennemis.TankNazi;
import Ennemis.Terroriste;
import Personnage.Personnage;
import Terrain.Bitume;
import Terrain.Case;
import Terrain.Ciel;
import Terrain.Coordonnees;
import Terrain.Sable;
import Terrain.Terre;

public class Terrain {
	private Case[][] tableau;
	private Personnage perso;
	BarreScore bs;
	
	
	public Terrain(int l, int c, int meilleurScore){
		setTableau(new Case[l][c]);
		setPerso(new Hero());
		bs = new BarreScore(this,meilleurScore);
		getPerso().setCoordonnees(new Coordonnees( l/2 , 3 )); //placement temporaire;
		initialiser();
		getTableau()[l/2][3].setPerso(getPerso());
	}
	public void initialiser(){
		for(int l=0 ; l<getTableau().length ; l++){
			for(int c=0; c<getTableau()[0].length ; c++){
				if( l == getTableau().length-1){
					getTableau()[l][c] = new Case( new Terre() );
				}else{	
					if( l < 3 ){
						getTableau()[l][c] = new Case( new Ciel() );
					}else{
						getTableau()[l][c] = new Case( new Ciel(false,false) );
					}
				}
			}
		}
	}
	public String toString(){
		String res = "";
		for(int l=0 ; l<getTableau().length ; l++){
			for(int c=0; c<getTableau()[0].length ; c++){
				res+=getTableau()[l][c].toString();
			}
			res += "\n";
		}
		return res;
	}
	public int[][] getJeu(){
		int[][] resultat = new int[getTableau().length][getTableau()[0].length];
		
		for(int l=0 ; l<getTableau().length ; l++){
			for(int c=0; c<getTableau()[0].length ; c++){
				
					if( getTableau()[l][c].getElement() instanceof Ciel){ 
						if( ((Ciel) getTableau()[l][c].getElement()).isNuageux() ){
							resultat[l][c] = 2;
						}else{
							if(((Ciel) getTableau()[l][c].getElement()).isOiseaux()){
								resultat[l][c] = 3;
							}else{
								if(((Ciel) getTableau()[l][c].getElement()).isMaison()){
									
									resultat[l][c] = 12+((Ciel) getTableau()[l][c].getElement()).getNumeroDecor() ;
								}else{
									if(((Ciel) getTableau()[l][c].getElement()).isPalmier() ){
										
										resultat[l][c] = 18 ;
									}else{
										if(((Ciel) getTableau()[l][c].getElement()).isUsine() ){
											
											resultat[l][c] = 17 ;
										}else{
											resultat[l][c] = 1;
										}
									}
								}
							}
						}
					}
					if(getTableau()[l][c].getElement() instanceof Sable){
						resultat[l][c] = 15 ;
					}
					if(getTableau()[l][c].getElement() instanceof Bitume){
						resultat[l][c] = 16 ;
					}
					if( getTableau()[l][c].getElement() instanceof Terre){ 
						resultat[l][c] = 4 ;
					}
					if( getTableau()[l][c].getEnnemi() instanceof AvionNazi){ 
						resultat[l][c] = 6 ;
					}
					if( getTableau()[l][c].getEnnemi() instanceof TankNazi){ 
						resultat[l][c] = 7 ;
					}
					if( getTableau()[l][c].getEnnemi() instanceof ObusNazi){ 
						resultat[l][c] = 32 ;
					}
					if( getTableau()[l][c].getEnnemi() instanceof CroixKKK){ 
						resultat[l][c] = 8 ;
					}
					if( getTableau()[l][c].getEnnemi() instanceof MembreKKK){ 
						resultat[l][c] = 9 ;
					}
					if( getTableau()[l][c].getEnnemi() instanceof AvionTerroriste){ 
						resultat[l][c] = 10 ;
					}
					if( getTableau()[l][c].getEnnemi() instanceof Terroriste){ 
						resultat[l][c] = 11 ;
					}
					
			}
		}
		resultat[getPerso().getCoordonnees().getAbscisse()][getPerso().getCoordonnees().getOrdonnee()] = 5;
		return resultat;
	}
	
	static public void main(String[] args){
		Terrain t = new Terrain(10 , 10,0);
		System.out.println(t.toString());
		
	}
	public Personnage getPerso() {
		return perso;
	}
	public void setPerso(Personnage perso) {
		this.perso = perso;
	}
	public Case[][] getTableau() {
		return tableau;
	}
	public void setTableau(Case[][] tableau) {
		this.tableau = tableau;
	}
}
