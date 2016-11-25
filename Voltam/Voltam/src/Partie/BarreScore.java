package Partie;

public class BarreScore{
	private Integer score = 0;
	private int HP;
	private Terrain terrain;
	private int meilleurScore;
	
	public BarreScore(Terrain terrain, int mScore){
		this.terrain = terrain;
		HP = terrain.getPerso().getNbVies();
		meilleurScore = mScore;
	}
	
	public int[] scoreToArray(Integer score){
		if(score < 999){
		String s = score.toString();
		int[] rep = new int[s.length()];
		for(int i =0; i<s.length();i++){
			rep[i] = Integer.parseInt(""+s.charAt(i));
		}
		return rep;
		}else return new int[]{9,9,9};
	}
	
		public int[][] getJeu(int[][] jeu){
			setHP(terrain.getPerso().getNbVies());
			
			int[][] barS = new int[jeu.length+1][jeu[0].length];
			for(int i = 0;i<barS[0].length;i++){
				barS[0][i] = 1;
				
			}
			
			
			
			
			
			for(int i = 0;i<HP;i++){
				barS[0][i] = 31; // 0 i 
			}
		for(int i = 0; i<scoreToArray(this.score).length;i++){
				int[] tabS = scoreToArray(this.score);
				switch(tabS[i]){
				case 0: barS[0][i+(barS[0].length/2)-2] = 19;break;
				case 1: barS[0][i+(barS[0].length/2)-2] = 20;break;
				case 2: barS[0][i+(barS[0].length/2)-2] = 21;break;
				case 3: barS[0][i+(barS[0].length/2)-2] = 22;break;
				case 4: barS[0][i+(barS[0].length/2)-2] = 23;break;
				case 5: barS[0][i+(barS[0].length/2)-2] = 24;break;
				case 6: barS[0][i+(barS[0].length/2)-2] = 25;break;
				case 7: barS[0][i+(barS[0].length/2)-2] = 26;break;
				case 8: barS[0][i+(barS[0].length/2)-2] = 27;break;
				case 9: barS[0][i+(barS[0].length/2)-2] = 28;break;
				}
			}
		
		for(int i = 0; i<scoreToArray(this.meilleurScore).length;i++){
			int[] tabS = scoreToArray(this.meilleurScore);
			switch(tabS[i]){
			case 0: barS[0][i+(barS[0].length - 5)] = 19;break;
			case 1: barS[0][i+(barS[0].length - 5)] = 20;break;
			case 2: barS[0][i+(barS[0].length - 5)] = 21;break;
			case 3: barS[0][i+(barS[0].length - 5)] = 22;break;
			case 4: barS[0][i+(barS[0].length - 5)] = 23;break;
			case 5: barS[0][i+(barS[0].length - 5)] = 24;break;
			case 6: barS[0][i+(barS[0].length - 5)] = 25;break;
			case 7: barS[0][i+(barS[0].length - 5)] = 26;break;
			case 8: barS[0][i+(barS[0].length - 5)] = 27;break;
			case 9: barS[0][i+(barS[0].length - 5)] = 28;break;
			}
		}
			for( int l = 0; l<jeu.length; l++){
				for(int c = 0 ; c<jeu[0].length ; c++){
					barS[l+1][c]= jeu[l][c];
				}
			}
			
			barS[0][(barS[0].length - 7)] = 29;
			barS[0][(barS[0].length - 6)] = 30;
			return barS ;
		}
	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getHP() {
		return HP;
	}
	public void setHP(int hP) {
		HP = hP;
	}
}
