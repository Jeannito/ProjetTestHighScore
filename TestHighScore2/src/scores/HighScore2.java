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

	
		/*We did it with the Arraylist for this time because it was very hard with the tables*/
	
		public BestPlayer[] tenBestScores(String[] readScores){
			String n;
			BestPlayer[] bestTenPlayer = new BestPlayer[10];
			int i=0;
			
			ArrayList<BestPlayer> allBest = new ArrayList<BestPlayer>();
			for (String ligne : readScores) {
				String[] scoreTab = ligne.split(",");
				if(scoreTab.length!=1){
	
				if(scoreTab.length==4){
					n = scoreTab[3];
				}
				else
				{
					n="";
				}
					
				int score = Integer.parseInt(scoreTab[2]);
				BestPlayer p = new BestPlayer(n, score);
				allBest.add(p);
				}
			}
			
			Collections.sort(allBest,Collections.reverseOrder());

			while(i < 10 && i < allBest.size()){
				bestTenPlayer[i] = allBest.get(i);
				i++;
			}
			return bestTenPlayer;
	}
}

