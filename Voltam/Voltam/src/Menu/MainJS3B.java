package Menu;
import Partie.Partie;
import Utilitaire.Cinematique;

public class MainJS3B {
		
	
	public static void main(String[] args) {
		lancerCinematique();
		Partie p = new Partie();
		MainMenu menu = new MainMenu(p.getMeilleurScore());
		
		int choix=0;
		do{
		choix=0;
	
		choix=menu.waitChoice();
		
		if(choix == 1){
			
			p.reset(menu.s);
			p.lancerPartie();
			
		}else{
			if(choix == 2){
				System.exit(0);
			}
		}
		}while(choix != 2);
		 
	
		
		
		
	}
	
	public static void lancerCinematique(){
		Cinematique cin = new Cinematique();
		cin.defiler();
		
	}
}
