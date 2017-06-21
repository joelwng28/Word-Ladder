/**
 * 
 */
package assignment3;

import java.util.*;
import java.io.*;
/**
 * @author liuxx
 *
 */
public class Main_test {
		public static final boolean DEBUG = true;

	// static variables and constants only here.
		public static ArrayList<String> dictionary;
		
		public static void main(String[] args) throws Exception {
			
			Scanner kb = new Scanner(System.in);;	// input Scanner for commands
			PrintStream ps = System.out;;	// output file, for student testing and grading only
			initialize();
			parse(kb);
			boolean[][] edges = new boolean[dictionary.size()][dictionary.size()];
			for(int i = 0; i <edges.length; i++){
				
				for(int j = 0; j < edges[i].length; j++){
					System.out.print(edges[i][j]);
					
				}
				
				System.out.println();
			}
		}
		
		public static void initialize() {
			Set<String> dict = makeDictionary();
			dictionary = new ArrayList<String>(dict);
		}
		
		public static void fillEdges(boolean[][] edges){
			for(int i = 0; i < dictionary.size(); i++){
				for(int j = 0; j < 5; j++){
					for(int k = i + 1; k < dictionary.size(); k++){
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
			if(DEBUG){
				System.out.println("Parse Test");
				System.out.println("Please enter something:");
			}
			ArrayList<String> inputList = new ArrayList<String>();
			
			while(keyboard.hasNextLine()){
				String newLine = keyboard.nextLine();
				Scanner lineScan = new Scanner(newLine);
				String word;
				
				int count = 0;
				while(lineScan.hasNext()){
					word = lineScan.next().toLowerCase();
					count ++;
					inputList.add(word);
					
					if(DEBUG){
						System.out.print("Input: ");
						System.out.println(word);
					}
				}
				
				if(count != 2){
					if(DEBUG){
						System.out.println("Input less/more than two words");
					}
					
					if(count == 1){
						if(inputList.get(0).toLowerCase().equals("quit")){
							break;
						}
						else{
							inputList.set(0, "INVALID");
							break;
						}
					}
					if(count >2){
						inputList.set(0, "INVALID");
						break;
					}
					
				}
				
				if(count == 2)
					break;
			}
			return inputList;
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
