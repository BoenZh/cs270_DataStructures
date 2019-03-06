

import java.util.Scanner;
public class BoggleGame {

	/** The whole game is played in this method
	 * 
	 * 
	 */
public static void main(String[] args) {
		Boggle board = new Boggle();
		Dictionary dict = new Dictionary();
		int points = 0;
		
		
		String str = "";
		
		System.out.println(board);
		Scanner in1 = new Scanner(System.in);
		System.out.println("Enter a word(enter 1 to end the game): ");
		str = in1.nextLine();
		
		
		while(!str.equals("1")){
		
		if (str.length() < 3){
			points = 0;
			System.out.println("The word " + str + " is too short!");
			//the word is too short
		}
		else{
			String lowerCaseKey = str.toLowerCase();
			if (!dict.searchWord(dict.readFile("words.txt"),lowerCaseKey, 0, dict.readFile("words.txt").length)){
				System.out.println("The word " + str + " is not a valid word");
				//the word is not in the dictionary
				}
			else {
				if (!board.findWord(str.toUpperCase())){
					System.out.println("The word " + str + " is a valid word, but is not on the board.");
					//the word cannot be found on the board
				}
				else{
					int i = str.length();
					if (i == 3 || i == 4)
						points += 1;
					else if (i == 5)
						points += 2;
					else if (i == 6)
						points += 3;
					else if (i == 7)
						points += 5;
					else 
						points += 11;
					System.out.println("The word " + str + " is good!" + "You score " + points + " points.");
					//the word can be found on the board, and record the points depending on the length of the word
				}
				
			}
			}System.out.println(board);
			Scanner in2 = new Scanner(System.in);
			System.out.println("Enter a word(enter 1 to end the game): ");
			str = in2.nextLine();
		}
		System.out.println("total score: "+points);
	}
}
	


