package scores;

public class BestPlayer{

	String name=new String();
	int score=0;

	public BestPlayer(){
		
	}

	public BestPlayer(String nom, int scr){

		score=scr;
		name=nom;
	}

	public int getScore(){

		return score;
	}

	public String getName(){

		return name;
	}

	public void setScore(int sc){

		score=sc;
	}

	public void setName(String nom){

		name=nom;
	}


	public int compareTo(BestPlayer bp){

		if (score<bp.getScore()) return -1;
		if (score>bp.getScore()) return 1;
		return 0;

	}




}