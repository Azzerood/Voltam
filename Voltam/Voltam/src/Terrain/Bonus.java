package Terrain;

public class Bonus {
	private String representation;
	private Coordonnees coordonnees;
	
	public Bonus(){
		setRepresentation("B");
	}

	public String getRepresentation() {
		return representation;
	}

	public void setRepresentation(String representation) {
		this.representation = representation;
	}

	public Coordonnees getCoordonnees() {
		return coordonnees;
	}

	public void setCoordonnees(Coordonnees coordonnees) {
		this.coordonnees = coordonnees;
	}
}
