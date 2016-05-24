package scores;

public class BestPlayer implements Comparable<BestPlayer>{

	
	
	String name=new String();
	int score=0;

	public BestPlayer(){
		
	}

	/**
	 * Receiving class data
	 * @param nom : name of the scorer
	 * @param scr : score
	 */
	public BestPlayer(String nom, int scr){

		score=scr;
		name=nom;
	}
	
	/**
	 * Getter score
	 * @return  the  user score
	 */

	public int getScore(){

		return score;
	}

	/**
	 * Getter name
	 * @return scorer's name
	 */
	
	public String getName(){

		return name;
	}

	/**
	 * Setter score
	 * @param sc : score attributed
	 */
	
	public void setScore(int sc){

		score=sc;
	}

	/**
	 * Setter name
	 * @param nom : scorer's name
	 */
	
	public void setName(String nom){

		name=nom;
	}

	/**
	 * Comparison with the best player of the tab
	 * @param bp : best player 
	 * @return -1 when player score is lower than the bp,
	 * 		    0 when equals, 
	 *          1 if it has beat the best score
	 */
	
	public int compareTo(BestPlayer bp){

		if (score<bp.getScore()) return -1;
		if (score>bp.getScore()) return 1;
		return 0;

	}




}