package scores;
import java.util.*;
import java.io.*;
import java.net.*;

	/**
	@author Hugo Fazio and Jean Bruté de Rémur
	@version 1
	*/

public class TestHighScore2 {
	
	/**
	Get name from input and return name
	@return name
	*/
    
    private static String askName(){
        System.out.println("Enter your name please :");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        sc.close();
        System.out.println("\nBienvenue " + name + "\n");
        return name;
    };
    
    	/**
		gets the scores from the csv
		@return a table with the scores
	*/
    
    private static String[] getRanking(){
    	int i = 0;
        int j = 0;
    	File ranking = new File("src/scores/scoreSamples.txt");
    	
    	/*
    	 * Recuperation du nombre de scores dans le fichier pour créer un tableau adapté
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
             
    };
    
	/**
		take a random value of the score table
		@param tab : tab of int containing the scores
		@return the random score value
	*/
	
    private static String getRandomScore(String[] S){
    	int k = S.length;
    	Random rand = new Random();
    	int nb = rand.nextInt(k);
    	return S[nb];
    };
    
    	/**
		print the score and name as output
		@param S : the name of player
		@param i : the score of player
	*/
    
    private static void result(String S, String i){
        System.out.println(S + " votre score est : " + i + "\n");
    };
    
    
    public static void main(String[] args){
    	
    	HighScore2 highScores = new HighScore2();
    	String[] scores = highScores.getScores();
    	System.out.println("Liste complete des scores sur le .csv :");
    	
    	int k = 0;
    	for(k=0;k<scores.length; k++){
    		System.out.println(scores[k]);
    	}
    	

    	
    	int j=0;
    	
    	//Ask the name
    	String name = askName();
    	
    	//Get all the score possible
    	String[] ranking = getRanking();
    	
    	//Get a random score
    	String score = getRandomScore(ranking);
    	
    	//Write the score and the name of the player
    	result(name, score); 
    	
		System.out.println("Et voici la liste complete des scores possibles :");
    	for(j=0;j<ranking.length;j++){
    		System.out.println(ranking[j]);
    	}
    	
    	//get the 10 best score
    	BestPlayer[] tenBest = highScores.tenBestScores(scores);
    	
    	//write the ten bests scores
    	System.out.println("Liste des dix meilleurs scores :");
    	
    	
		for (int i=0;i<tenBest.length;i++){        			
            System.out.println(" Nom: "+tenBest[i].getName()+" Score: "+tenBest[i].getScore());

    	}
    }
}
