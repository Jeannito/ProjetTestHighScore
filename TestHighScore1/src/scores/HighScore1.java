package scores;
import java.net.*;
import java.io.*;



public class HighScore1 {

	/*
	 *  Constructeur
	 */

  	public void HighScore() {	
	}
	
	/*
	 *  Fonction getScores permetant de recuperer les scores
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
  
}
