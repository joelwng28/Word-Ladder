/* WORD LADDER Main.java
 * EE422C Project 3 submission by
 * Replace <...> with your actual data.
 * Zi Zhou Wang
 * zw3948
 * 76175
 * <Student2 Name>
 * <Student2 EID>
 * <Student2 5-digit Unique No.>
 * Slip days used: <0>
 * Git URL:https://github.com/joelwng28/assignment3
 * Summer 2017
 */


package assignment3;
import java.util.*;
import java.io.*;

public class Main {
	public static final boolean DEBUG = false;
	// static variables and constants only here.
	public static ArrayList<String> dictionary;
	public static ArrayList<ArrayList<String>> edges;
	
	public static void main(String[] args) throws Exception {
		
		Scanner kb;	// input Scanner for commands
		PrintStream ps;	// output file, for student testing and grading only
		// If arguments are specified, read/write from/to files instead of Std IO.
		if (args.length != 0) {
			kb = new Scanner(new File(args[0]));
			ps = new PrintStream(new File(args[1]));
			System.setOut(ps);			// redirect output to ps
		} else {
			kb = new Scanner(System.in);// default input from Stdin
			ps = System.out;			// default output to Stdout
		}
		initialize();
		//ArrayList<String> list = parse(kb);
		fillEdges();
		System.out.println(edges);
		//printLadder(list);
	}
	
	public static void initialize() {
		Set<String> dict = makeDictionary();
		dictionary = new ArrayList<String>(dict);
		edges = new ArrayList<ArrayList<String>>();
	}
	
	public static void fillEdges(){
		for(int i = 0; i < dictionary.size(); i++){
			ArrayList<String> temp = new ArrayList<String>();
			for(int j = 0; j < 5; j++){
				for(int k = (i + 1); k < dictionary.size(); k++){
					if(dictionary.get(i).substring(0,j).equals(dictionary.get(k).substring(0,j)) && dictionary.get(i).substring((j+1),5).equals(dictionary.get(k).substring((j+1),5))){
						temp.add(dictionary.get(k));
					}
				}
			}
			edges.add(temp);
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
					if(inputList.get(0).toLowerCase().equals("/quit")){
						lineScan.close();
						break;
					}
					else{
						inputList.set(0, "INVALID");
						lineScan.close();
						break;
					}
				}
				if(count >2){
					inputList.set(0, "INVALID");
					lineScan.close();
					break;
				}
				
			}
			
			if(count == 2)
				lineScan.close();
				break;
		}
		return inputList;
	}
	
	public static ArrayList<String> getWordLadderDFS(String start, String end) {
		
		// Returned list should be ordered start to end.  Include start and end.
		// If ladder is empty, return list with just start and end.
		ArrayList<String> temp = new ArrayList<String>();
		for(int i = 0; i < 5; i++){
			if(start.substring(0,i).equals(end.substring(0,i)) && start.substring((i+1),5).equals(end.substring((i+1),5))){
				temp.add(start);
				temp.add(end);
			}
		}
		return temp;
	}
	
    public static ArrayList<String> getWordLadderBFS(String start, String end) {
		
		// TODO some code
		// TODO more code
		
		return null; // replace this line later with real return
	}
    
	
	public static void printLadder(ArrayList<String> ladder) {
		for(int i = 0; i < ladder.size(); i++){
			System.out.println(ladder.get(i));
		}
	}
	// TODO
	// Other private static methods here


	/* Do not modify makeDictionary */
	public static Set<String>  makeDictionary () {
		Set<String> words = new HashSet<String>();
		Scanner infile = null;
		try {
			infile = new Scanner (new File("short_dict.txt"));
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
