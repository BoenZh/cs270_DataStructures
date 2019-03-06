/**
 * Name: zhang boen
  Assignment: Lab 08
  Title: boggle
  Course: CSCI 270
  Lab Section: 01
  Semester: Fall, 2016
  Instructor: Dr. Blaha
  Date: 11/14/2016
  Sources consulted: none
  Program description: boggle game
  Known Bugs: none
  Creativity: none
 */

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class Boggle {

	private char[][] board;//create a board to load the elements.
	Cell a = new Cell(4);//set default cell as 4
	
	
	/** Constructor of Boggle which reads file from the target file and create 
	 * a matrix to load the file
	 * 
	 */
	public Boggle(){
		
		Scanner scan;
		
	     
	    try {
	          scan = new Scanner( new File ( "board.txt" ) );
	         int size =  Integer.parseInt(scan.next());
	          this.board = new char[size][size];
	          Cell a = new Cell(size);//create a cell to take notes of the visited element.
	    	
	          for( int i = 0; i < size; i++) 
	    		for(int j = 0; j < size; j++)
	    			this.board[i][j] = scan.next().charAt(0);
	    		
	    	
	    	
	       } catch (IOException e) {
	          System.err.println("Error reading from: " + "board.txt");
	          System.exit(1);
	       }
	     }
	
	
	/** to find a word by searching its each letter on boggle
	 * 
	 * @param word word that users input
	 * @return return true if the word can be found in the board, return false otherwise
	 */
	   public boolean findWord(String word) {
	        for (int row = 0; row < this.board.length; row++) {
	            for (int col = 0; col < this.board.length; col++) {
	                if (this.findWord(word, row, col)) {
	                    return true;
	                }
	            }
	        }
	        return false;
	    }
	   /**
	    * 
	    * @param word word that users input
	    * @param row current row number of the letter
	    * @param col current column number of the letter
	    * @return return true if the word can be found in the board, return false otherwise
	    */
	   private boolean findWord(String word, int row, int col) {
	        if (word.equals("")) {
	            return true;
	        }
	        else if (row < 0 || row >= this.board.length ||
	        		 col < 0 || col >= this.board.length || 
		             this.board[row][col] != word.charAt(0)) {
		            return false;
	        }
	        
	        else if (a.getVisited(row, col)){
	        	return false;
	        
	        }
	        else {
	            a.markVisited(row,col);//mark this point as visited on the cell
	            String rest = word.substring(1, word.length());
	             if (this.findWord(rest, row-1, col-1))
	            	 return true;
	             if (this.findWord(rest, row-1, col))
	            	 return true;
	             if (this.findWord(rest, row-1, col+1))
	            	 return true;
	             if (this.findWord(rest, row, col-1))
	            	 return true;
	             if (this.findWord(rest, row, col+1))
	            	 return true;
	             if (this.findWord(rest, row+1, col-1))
	            	 return true;
	             if (this.findWord(rest, row+1, col))
	            	 return true;
	             if (this.findWord(rest, row+1, col+1))
	            	 return true;
	             a.markUnVisited(row, col);//unmark the visited point because we need to go back to search next letter
	             return false;
	           
	        }
	    }
	   /**
	     * Converts the board to a String (with line breaks after each row)
	     *   @return the string version of the board
	     */
	    public String toString() {
	        String str = "";
	        for (int r = 0; r < board.length; r++) {
	            for (char ch : board[r]) {
	                str += ch + " ";
	            }
	            if (r < board.length-1) { 
	                str += "\n"; 
	            }
	        }
	        return str;
	    }
}

