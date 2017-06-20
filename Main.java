/* WORD LADDER Main.java
 * EE422C Project 3 submission by
 * Replace <...> with your actual data.
 * <Student1 Name>
 * <Student1 EID>
 * <Student1 5-digit Unique No.>
 * <Student2 Name>
 * <Student2 EID>
 * <Student2 5-digit Unique No.>
 * Slip days used: <0>
 * Git URL:
 * Summer 2017
 */


package assignment3;
import java.util.*;
import java.io.*;

public class Main {
	
	// static variables and constants only here.
	public static ArrayList<String> dictionary;
	
	public static void main(String[] args) throws Exception {
		
		Scanner kb = new Scanner(System.in);;	// input Scanner for commands
		PrintStream ps = System.out;;	// output file, for student testing and grading only
		initialize();
		parse(kb);
		boolean[][] edges = new boolean[dictionary.size()][dictionary.size()];
		System.out.print(edges[0][0]);
	}
	
	public static void initialize() {
		Set<String> dict = makeDictionary();
		dictionary = new ArrayList<String>(dict);
	}
	
	public static void fillEdges(boolean[][] edges){
		for(int i = 0; i < dictionary.size(); i++){
			for(int j = 0; j < 5; j++){
				for(int k = 0; k < dictionary.size(); k++){
					if(dictionary.get(i).substring(0,j).equals(dictionary.get(k).substring(0,j)) && dictionary.get(i).substring((j+1),5).equals(dictionary.get(k).substring((j+1),5))){
						edges[i][k] = true;
					}
				}
			}
		}
	}
	
	/**
	 * @param keyboard Scanner connected to System.in
	 * @return ArrayList of Strings containing start word, rungs, and end word. 
	 * If command is /quit, return empty ArrayList. 
	 */
	public static ArrayList<String> parse(Scanner keyboard) {
		
		return null;
	}
	
	public static ArrayList<String> getWordLadderDFS(String start, String end) {
		
		// Returned list should be ordered start to end.  Include start and end.
		// If ladder is empty, return list with just start and end.
		// TODO some code

		// TODO more code
		
		return null; // replace this line later with real return
	}
	
    public static ArrayList<String> getWordLadderBFS(String start, String end) {
		
		// TODO some code
		// TODO more code
		
		return null; // replace this line later with real return
	}
    
	
	public static void printLadder(ArrayList<String> ladder) {
		
	}
	// TODO
	// Other private static methods here


	/* Do not modify makeDictionary */
	public static Set<String>  makeDictionary () {
		Set<String> words = new HashSet<String>();
		Scanner infile = null;
		try {
			infile = new Scanner (new File("five_letter_words.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("Dictionary File not Found!");
			e.printStackTrace();
			System.exit(1);
		}
		while (infile.hasNext()) {
			words.add(infile.next().toUpperCase());
		}
		return words;
	}
}
