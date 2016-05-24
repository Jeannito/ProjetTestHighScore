package scores;
import java.util.*;
import java.io.*;


	/**
	 * @author Hugo Fazio and Jean Bruté de Rémur
	 * @version 4
	 */

public class TestHighScore4 {
	
	/**
	 * Ask and take back the user name
	 * @return name
	 */
    
    private static String askName(){
        System.out.println("Enter your name please :");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        /*sc.close();*/
        System.out.println("\nBienvenue " + name + "\n");
        return name;
    }
    
	/**
	 * Take all scores in one tab
	 * @return tab of scores
	 */
    
    private static String[] getRanking(){
    	int i = 0;
        int j = 0;
    	File ranking = new File("src/scores/scoreSamples.txt");
    	
    	/*
    	 Recuperation du nombre de scores dans le fichier pour créer un tableau adapté
    	 */
    	try {	
    		FileReader read = new FileReader(ranking);
    		BufferedReader buffer = new BufferedReader(read);
        	String bf2 = buffer.readLine();
        	
        	while(bf2!= null){
        		j++;
        		bf2 = buffer.readLine();
        	}
        	
        	buffer.close();
        	read.close();
    	}
    	catch(FileNotFoundException e){
        	e.printStackTrace();
        }
        catch(IOException e){
        	e.printStackTrace();
        }
    	
        
    	/*
    	 * Definition du tableau et recuperation des scores
    	 */
    	String[] score = new String[j];
    	
    	try {
        	FileReader read = new FileReader(ranking);
        	BufferedReader buffer1 = new BufferedReader(read);
        	String bf1 = buffer1.readLine();
  
        	while(bf1!= null){
        		score[i] = bf1;
        		i++;
        		bf1 = buffer1.readLine();
        	}
        	buffer1.close();
        	read.close();
        }
        catch(FileNotFoundException e){
        	e.printStackTrace();
        }
        catch(IOException e){
        	e.printStackTrace();
        }
        return score;
             
    }
    
	/**
	 * Select a random score from the existing scores
	 * @param S : tab of the scores
	 * @return the random score obtained
	 */
    
    private static String getRandomScore(String[] S){
    	int k = S.length;
    	Random rand = new Random();
    	int nb = rand.nextInt(k);
    	return S[nb];
    }
    
    /**
     * Returning his own score to the user
     * @param S : user name
     * @param i : user score
     */
    private static void result(String S, String i){
        System.out.println(S + " votre score est : " + i + "\n");
    }
    
    public static void main(String[] args){
    	
    	
    	String choice = "y";
    	
    	//Ask the name
    	String name = askName();
    	
    	while(choice.equals("y")){
	    	HighScore4 highScores = new HighScore4();
	    	String[] scores = highScores.getScores();
	    	System.out.println("Liste complete des scores sur le .csv :");
	    	
	    	int k = 0;
	    	for(k=0;k<scores.length; k++){
	    		System.out.println(scores[k]);
	    	}
	    	
	    	//Get all the score possible
	    	String[] ranking = getRanking();
	    	
	    	//Get a random score
	    	String score = getRandomScore(ranking);
	    	
	    	//Write the score and the name of the player
	    	result(name, score); 
	    	
			/*System.out.println("Et voici la liste complete des scores possibles :");
	    	for(j=0;j<ranking.length;j++){
	    		System.out.println(ranking[j]);
	    	}*/
	    	
	        System.out.println("\n");
	    	
	    	
	    	
	    	//get the 10 best score
	    	BestPlayer[] tenBest = highScores.tenBestScores(scores);
	    	
	    	//write the ten bests scores
	    	System.out.println("Liste des dix meilleurs scores :");
	    	
	    	
			for (int i=0;i<tenBest.length;i++){        			
	            System.out.println(" Nom: "+tenBest[i].getName()+" Score: "+tenBest[i].getScore());
	
	    	}
			
			System.out.println("\n");
			
			for (int y=0;y<tenBest.length;y++)
	    	{
	        		if (Integer.parseInt(score) > tenBest[y].getScore())
	        		{
	            		highScores.sendScore(new BestPlayer(name,Integer.parseInt(score)));
	            		System.out.println(" Le score suivant a bien était envoyé: "+name+" "+score);
	            		break;
	        		}
	        		else
	        		{
	        			y++;
	        		}
	    	}
			
			Scanner scan = new Scanner(System.in);
			System.out.println("Do you want to play again ? (y/n)");
			choice = scan.nextLine();
			/*scan.close();*/
    	}
    }
}
