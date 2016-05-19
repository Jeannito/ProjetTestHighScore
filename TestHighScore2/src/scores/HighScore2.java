package scores;
import java.util.*;
import java.io.*;
import java.net.*;

/**
		@author Hugo Fazio Jean Bruté de Rémur
		@version 1
 */

public class HighScore2 {

	/*
	 *  Constructeur
	 */

	public void HighScore() {	
	}

	/**
	 Return the result of the feed.csv
	 @return a tab with the values read from the channel
	 */

	public String[] getScores(){

		String[] temp = new String[500];
		int i=0;


		try {

			URL link = new URL("https://thingspeak.com/channels/111610/feeds.csv");
			URLConnection connexion = link.openConnection();
			InputStreamReader Stream = new InputStreamReader(connexion.getInputStream());
			BufferedReader buffer = new BufferedReader(Stream);
			String header = buffer.readLine();

			/*
			 * Saut de ligne dans le fichier pour ne pas recuperer la ligne de definition
			 */

			header = buffer.readLine();
			while(header!= null){
				temp[i] = header;
				i++;
				header = buffer.readLine();
			}

			Stream.close();
		} catch (Exception e) { 
			e.printStackTrace(); 
		}


		/*
		 *  On recupere les données du tableau temporaire pour ajuster la taille
		 */

		String[] result = new String[i];
		int j =0;
		for (j=0; j<i ; j++){
			result[j]=temp[j];
		}



		return result;


	}


	/*public BestPlayer[] tenBestScores(String [] readScores){

		BestPlayer[] allBest= new BestPlayer[readScores.length];

		for(int i=0;i<readScores.length;i++){
			String[] parts = ((String)readScores[i]).split(",");
			
			if(parts.length!=1){
				allBest[i]=new BestPlayer();
				if(parts.length==4){
					allBest[i].setName(parts[3]);
				}else{
					allBest[i].setName("");
				}
				allBest[i].setScore(Integer.parseInt(parts[2]));
				
			}
		}




		int i=1;
		BestPlayer temp;
		BestPlayer temp1;

		while((i<allBest.length)){
			

			int j = i;
			while(allBest[j-1].getScore() < allBest[j].getScore() && j>=1)
			{
				System.out.println("test"+allBest[j].getScore()+":"+allBest[j].getName());
				temp1 = allBest[j];
				temp = allBest[j-1];
				allBest[j-1] = temp1;
				allBest[j] = temp;

				j--;
			}

			i++;

		}

		BestPlayer[] resultat = new BestPlayer[10];

		int y=0;
		for(y=0;y<10;y++){

			resultat[y]= allBest[y];

		}


		return resultat;*/
	
		public BestPlayer[] tenBestScores(String [] readScores){

			BestPlayer[] allBest= new BestPlayer[readScores.length];
	
			for(int i=0;i<readScores.length;i++){
				String[] parts = ((String)readScores[i]).split(",");
				
				if(parts.length!=1){
					allBest[i]=new BestPlayer();
					if(parts.length==4){
						allBest[i].setName(parts[3]);
					}else{
						allBest[i].setName("");
					}
					allBest[i].setScore(Integer.parseInt(parts[2]));
			}
			}
			
			int y=0;
			int j=0;
			List<BestPlayer> resList = new ArrayList<BestPlayer>();
			BestPlayer mem;
	
			while((y<allBest.length) && (y<10)){
				
				mem= allBest[0];
		    	System.out.println(""+allBest[y].getName()+""+allBest[y].getScore());
				for(j=0;j<allBest.length;j++){
					
					if((allBest[j].compareTo(mem)>=0)&& !(resList.contains(allBest[j]))){
	
						mem=allBest[j];
					}
				}
	
				resList.add(mem);
				y++;
	
			}
		return resList.toArray(new BestPlayer[10]);
	}
}

