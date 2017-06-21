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

public class Main_xx {
	
	public static final boolean DEBUG = true;
	
	// static variables and constants only here.
	
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
		
		// TODO methods to read in words, output ladder
	}
	
	public static void initialize() {
		// initialize your static variables or constants here.
		// We will call this method before running our JUNIT tests.  So call it 
		// only once at the start of main.
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
		Set<String> dict = makeDictionary();
		// TODO more code
		
		return null; // replace this line later with real return
	}
	
    public static ArrayList<String> getWordLadderBFS(String start, String end) {
		
    	ArrayList<String> newList = new ArrayList<String>();

    	//Check the length first
    	if(start.length() != end.length()){
    		newList.add("INVALID INPUT");
    		return newList;
    	}

    	//Check if there is a word in the input string
    	if(start.length() == 0){
    		newList.add("INVALID INPUT");
    		return newList;
    	}

    	//Setup dictionary
		Set<String> dict = makeDictionary();
		
		if(dict.isEmpty()){
			newList.add("INVALID DICT");
    		return newList;
		}
		
		//Setup two queues for BFS
		Queue<String> push = new LinkedList<String>();
		Queue<String> pop = new LinkedList<String>();

		pop.add(start);
		char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		
		while(dict.size() > 0 && !pop.isEmpty()){
			boolean flag = false;
			while(!pop.isEmpty() && !flag){
				String str = pop.peek();
				//The execution bound of this for loop should be the length of start
				for(int i = 0; i < str.length() && !flag; i++){
					//The execution bound of this for loop should be 26
					for(int j = 0; j < alphabet.length; j++){
						
						if(str.charAt(i) == alphabet[j]){
							//go to next iteration
							continue;
						}
						
						//Create the temporary word 
						//The temp word differs the original word by one character
						char[] tempChar = str.toCharArray();
						tempChar[i] = alphabet[j];
						String tempString = String.valueOf(tempChar);
						
						//Check if the Ladder has reach to the end
						if(tempString.equals(end)){
							//The ladder has been found
							//return
							flag = true;
							break;
						}
						
						//Check if the dict contains the word
						if(dict.contains(tempString)){
							//the word is in dict
							//push it into the queue and delete it from dict
							push.add(tempString);
							dict.remove(tempString);
						}
					}
				}
				if(!flag){
					pop.poll();
				}
			}
			
			if(flag){
				
			}
			else{
				pop = swap(push);
			}
		}

		
		return null; // replace this line later with real return
	}
    
    private static Queue<String> swap(Queue<String> input){
    	Queue<String> res = new LinkedList<String>();
    	while(!input.isEmpty()){
    		res.add(input.poll());
    	}
    	input.clear();
    	return res;
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
