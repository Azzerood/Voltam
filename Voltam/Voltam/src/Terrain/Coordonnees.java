package Terrain;

public class Coordonnees {
	private int x;	
	private int y;
	
	public int getAbscisse(){
		return x;
	}
	public void setAbscisse(int abs){
		x = abs;
	}
	public int getOrdonnee(){
		return y;
	}
	public void setOrdonnee(int ord){
		y = ord;
	}
	public Coordonnees(int abs , int ord){
		x = abs ;
		y = ord ;
	}
}
