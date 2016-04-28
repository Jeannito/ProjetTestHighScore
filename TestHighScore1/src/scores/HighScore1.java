package scores;
import java.net.*;
import java.io.*;



public class HighScore1 {

  	public void HighScore() {	
	}
	
	 
	public String[] getScores(){

		String[] temp = new String[500];
		int i=0;


		try {

		URL link = new URL("https://thingspeak.com/channels/111610/feeds.csv");
		URLConnection connexion = link.openConnection();
		InputStreamReader inStream = new InputStreamReader(connexion.getInputStream());
		BufferedReader buffer = new BufferedReader(inStream);
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
		
		inStream.close();
		
		} catch (Exception e) { 
			e.printStackTrace(); 
		}
		String[] result = new String[i];
		int j =0;
		for (j=0; j<i ; j++){
			result[j]=temp[j];
		}
		
		
		
		return result;
		
		
	}
  
}