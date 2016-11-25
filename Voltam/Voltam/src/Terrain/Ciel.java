package Terrain;
import java.util.Random;

public class Ciel extends Element{
	
	private boolean nuageux = false;
	private boolean oiseaux = false;
	private boolean maison = false;
	private boolean palmier = false;
	private boolean usine = false;
	private int numeroDecor = 0;
	
	public Ciel(){
		setRepresentation("C");
		Random Rand = new Random();
		int random = Rand.nextInt(1000);
			if(random  > 90 && random <100 ){
				setOiseaux(true);
			}else{
				setOiseaux(false);
				if(random > 950){
					setNuageux(true);
				}else{
					setNuageux(false) ;
				}
			}
		this.setAccessible(true);
	}
	public Ciel(boolean nuage){
		this();
		setNuageux(nuage);
		
	}
	
	public Ciel(boolean nuage,boolean oiseaux){
		this(nuage);
		setOiseaux(oiseaux);
		
	}
	public Ciel(boolean nuage,boolean oiseaux, boolean maison){
		this(nuage, oiseaux);
		setMaison(maison);
		setNumeroDecor(new Random().nextInt(3));
		
	}
	public Ciel(boolean nuage,boolean oiseaux, boolean maison, boolean palmier){
		this(nuage, oiseaux, maison);
		setPalmier(palmier);
		
	}
	public Ciel(boolean nuage,boolean oiseaux, boolean maison, boolean palmier, boolean usine) {
		this(nuage, oiseaux, maison, palmier);
		setUsine(usine);
		
	}
	public boolean isNuageux() {
		return nuageux;
	}

	public void setNuageux(boolean nuageux) {
		this.nuageux = nuageux;
	}
	public boolean isOiseaux() {
		return oiseaux;
	}
	public void setOiseaux(boolean oiseaux) {
		this.oiseaux = oiseaux;
	}
	public boolean isMaison() {
		return maison;
	}
	public void setMaison(boolean maison) {
		this.maison = maison;
	}
	public boolean isPalmier() {
		return palmier;
	}
	public void setPalmier(boolean palmier) {
		this.palmier = palmier;
	}
	public int getNumeroDecor() {
		return numeroDecor;
	}
	public void setNumeroDecor(int numeroDecor) {
		this.numeroDecor = numeroDecor;
	}
	public boolean isUsine() {
		return usine;
	}
	public void setUsine(boolean usine) {
		this.usine = usine;
	}
}
