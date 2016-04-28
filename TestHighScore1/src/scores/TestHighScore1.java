package scores;
import java.util.*;
import java.io.*;

public class TestHighScore1 {
    
    private static String askName(){
        System.out.println("Enter your name please :");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        sc.close();
        System.out.println("\nBienvenue " + name + "\n");
        return name;
    };
    
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
    /*
     * Tirage aleatoire dans le tableau, en utilisant sa taille
     */
    private static String getRandomScore(String[] S){
    	int k = S.length;
    	Random rand = new Random();
    	int nb = rand.nextInt(k);
    	return S[nb];
    };
    
    private static void result(String S, String i){
        System.out.println(S + " votre score est : " + i + "\n");
    };
    
    
    public static void main(String[] args){
    	
    	HighScore1 highScores = new HighScore1();
    	String[] scores = highScores.getScores();
    	System.out.println("Liste complete des scores sur le .csv :");
    	
    	int k = 0;
    	for(k=0;k<scores.length; k++){
    		System.out.println(scores[k]);
    	}
    	
    	
    	int j=0;
    	String name = askName();
    	String[] ranking = getRanking();
    	String score = getRandomScore(ranking);
    	result(name, score); 
    	
		System.out.println("Et voici la liste complete des scores en .txt :");
    	for(j=0;j<10;j++){
    		System.out.println(ranking[j]);
    	}
    }
}