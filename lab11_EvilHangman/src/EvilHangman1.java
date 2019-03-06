/**
 * Name: zhang boen
  Assignment: Lab 11
  Title: EvilHangman1
  Course: CSCE 270
  Lab Section: 01
  Semester: fall, 2016
  Instructor: Dr. Blaha
  Date: 12/05/2016
  Sources consulted: none
  Program description: EvilHangman1
  Known Bugs: none
  Creativity: none
 */

import java.util.ArrayList;

import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;


public class EvilHangman1 {

		
		
		private static String ans = "";
		private static int leng = 0;
		private static int numOfGuesses = 0;
		private static String answer="";
		
		public static void main(String args[]){
		Scanner in1 = new Scanner(System.in);
		do {
			gameSetUp(in1);
			startGame(in1);
			
		}while(oneMoreGame(in1));
		}
		
		/**
		 * this method is to du one more game
		 * @param in1 the scanner
		 * @return onem= more game or not
		 */
		private static boolean oneMoreGame(Scanner in1){
			System.out.println("Do you want to play another game?(yes or no)");
			ans  = in1.nextLine();
			if(ans.equalsIgnoreCase("yes") && ans.length() > 0){
				return true;
			}
			else {
				return false;
			}
		}
		
		/**
		 * ask user to display running word or not
		 * @param in1 the scanner
		 * @return the boolean to display or not
		 */
		private static boolean totalWord(Scanner in1){
			System.out.println("Do you want to see the running total of words?");
			if(answer.equalsIgnoreCase("yes") && answer.length() > 0){
				return true;
			}
			else {
				return false;
			}
		}
		
		/**
		 * the setup to setup the dic map
		 * @param in1 scanner in1
		 */
		private static void gameSetUp(Scanner in1){
			
			do{
				System.out.println("Enter the length of the word you want to guess: ");
				leng = Integer.parseInt(in1.nextLine());
			}while(leng == 0 || leng == 26 || leng == 27 || leng > 29);
			
			
			do{
				System.out.println("Enter the number of guesses you want to use");
				numOfGuesses = Integer.parseInt(in1.nextLine());
				System.out.println("Do you want to see the running total of words?");
				answer=in1.nextLine();
				
				
			}while(numOfGuesses < 1 );
		}
		
		/**
		 * the method for the real game play
		 * @param in1 scanner in1
		 */
		private static void startGame(Scanner in1){
			TreeMap<String, ArrayList<String>> wordList = new TreeMap<String, ArrayList<String>>();
			 String pattern = "";
			 String word = "";
			 Dictionary dict = new Dictionary();
			 ArrayList<String> words1 = dict.readFile("dictionary.txt");
			 ArrayList<String> words2 = new ArrayList<String>();
			for (int i = 0; i < words1.size(); i++){
				if (words1.get(i).length() == leng)
					words2.add(words1.get(i));
			}
			int numOfGuessesLeft = numOfGuesses;
			String guessedWords = "";
			for (int i = 0; i < leng; i++){
				pattern += "?";
			}
			
			while (numOfGuessesLeft > 0 && pattern.contains("?")){
				System.out.println("Enter a letter you guess: ");
					char letter = in1.nextLine().charAt(0);
					ArrayList<Character> check1=new ArrayList<Character>();
					
					for(int i=0;i<check1.size();i++){
						if(check1.get(i).compareTo(letter)==0){
							System.out.println("already guessed, please enter another letter.");
							numOfGuessesLeft++;
						}	
					}
					check1.add(letter);
					
					 guessedWords += Character.toString(letter) + " ";
					 
				for (int i = 0; i < words2.size(); i++){
					word = words2.get(i);
					
					String patternModi = patternChange(letter, pattern, word);
			
					if (!wordList.containsKey(patternModi)){
						ArrayList<String> patterns = new ArrayList<String>();
						patterns.add(word);
						wordList.put(patternModi,patterns);
					}
					else{
					wordList.get(patternModi).add(word);
				}
				}
				
				String newKey = "";
				String key="";
				int max = 0;
				String oldPattern="";
				
				for(Map.Entry<String,ArrayList<String>> entry : wordList.entrySet()) 
				{
					  //String key = entry.getKey();  
					  key = entry.getKey();
					  ArrayList<String> value = entry.getValue(); 
					  int size = value.size();
					  if(size > max){
						  newKey = key;
						  max = size;
					  }
				}
				words2 = wordList.get(newKey);
				oldPattern=pattern;
				pattern = newKey;
				if(!(pattern.compareToIgnoreCase(oldPattern)==0))
					numOfGuessesLeft = numOfGuessesLeft + 1;
				wordList.clear();
				numOfGuessesLeft = numOfGuessesLeft - 1;
				if(!pattern.contains("?")){
					System.out.println("Congratulation! You win!");
				}
				else{
					if(numOfGuessesLeft > 0){
				System.out.println("Guesses Left: " + numOfGuessesLeft + ";" + "\n" + 
				"Words already guessed: " + guessedWords + ";" + "\n" + "Current word"
				+ " pattern that you've accomplished: " + newKey);
				
				if(answer.equals("yes")){
					System.out.println("\n"+"running number of words: "+words2.size());
				}
				}
					else {
						System.out.println("You lose...");
					}
				}
			}
					
		}
		
		/**
		 * the pattern changer of arrayList
		 * @param l key
		 * @param p the value in the old patton
		 * @param w the changes
		 * @return the new set of words
		 */
		private static String patternChange(char l, String p, String w){
			String[] newPattern = new String[w.length()];
			for (int i = 0; i < p.length(); i++){
				newPattern[i] = Character.toString(p.charAt(i));
			}
			String realPattern = "";	
			for (int i = 0; i < w.length(); i++){
				if (w.charAt(i) == l){
					newPattern[i] = Character.toString(l);
				}
				else {
					newPattern[i] = newPattern[i];
				}
			}
			for (int j = 0; j < newPattern.length; j++){
				realPattern += newPattern[j];
			}
			
			return realPattern;
		}
 		
}
	
		
		
	
		
		
		
		
		
		
	
		
		
	
		
	
		
		
	


