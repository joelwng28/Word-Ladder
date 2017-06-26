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
		//printLadder(list);
		System.out.println(getWordLadderDFS("HELLO", "CELLS"));
	}
	
	public static ArrayList<String> getWordLadderDFS(String start, String end) {
		
		// Returned list should be ordered start to end.  Include start and end.
		// If ladder is empty, return list with just start and end.
		ArrayList<String> answer = new ArrayList<String>();
		ArrayList<String> edges = fillEdges(start);
		if(edges.contains(end)){
			answer.add(start);
			answer.add(end);
			initialize();
			return answer;
		}
		dictionary.remove(start);
		while(!edges.isEmpty()){
			ArrayList<String> temp = getWordLadderDFS(edges.get(0), end);
			if(temp != null){
				answer.add(start);
				answer.addAll(temp);
				return answer;
			}
			edges.remove(0);
		}
		return null;
	}
	
	
	public static void initialize() {
		Set<String> dict = makeDictionary();
		dictionary = new ArrayList<String>(dict);
	}
	
	public static ArrayList<String> fillEdges(String str){
		ArrayList<String> temp = new ArrayList<String>();
		for(int i = 0; i < dictionary.size(); i++){
			if(!str.equals(dictionary.get(i))){
				for(int j = 0; j < 5; j++){
					if(str.substring(0,j).equals(dictionary.get(i).substring(0,j)) && str.substring((j+1),5).equals(dictionary.get(i).substring((j+1),5))){
						temp.add(dictionary.get(i));
					}
				}
			}
		}
		return temp;
	}
	/**Parse method
	 * This method takes input from keyboard and determine if the input is valid
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
					if(inputList.get(0).toLowerCase().equals("quit"))
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
	
    public static ArrayList<String> getWordLadderBFS(String start, String end) {

    	
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
