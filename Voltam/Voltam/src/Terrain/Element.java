package Terrain;

public class Element {

	private boolean accessible;
	private String representation = " ";
	
	
	public boolean isAccessible(){
		return accessible;
	}


	public String getRepresentation() {
		return representation;
	}
	public void setAccessible(boolean a){
		accessible = a ;
	}

	public void setRepresentation(String representation) {
		this.representation = representation;
	}
}
