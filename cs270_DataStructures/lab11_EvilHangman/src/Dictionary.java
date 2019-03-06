import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Dictionary {

	ArrayList<String> arr;
	/**Constructor of Dictionary, to call readFile method
	 * 
	 */
	public Dictionary(){
		readFile("dictionary.txt");
		
	}
	
	/**
	 * 
	 * @param fileName file from other txt or sources
	 * @return return an array of String that has all of words in dictionary
	 */
	public ArrayList<String> readFile(String fileName){
			
			ArrayList<String> data = new ArrayList<String>();
			// Create the scanner (open the file for reading)
			Scanner scan;
		    String line = "";
		     
		    try {
		          scan = new Scanner( new File ( fileName ) );
		          // Start reading lines from the file
			    	while(scan.hasNext()) {
			            //start process the next line
			        line = scan.nextLine();
			        data.add(line);
			         // start reading data from line
			    	}
			    	// Copy the ArrayList into an array and return it.
			    	
			    	
		          
		       } catch (IOException e) {
		          System.err.println("Error reading from: " + fileName);
		          System.exit(1);
		       }
		 	return data;
		  
		         
	}
	

}
