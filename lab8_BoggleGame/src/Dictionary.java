import java.io.File;
	import java.io.IOException;
	import java.util.*;

public class Dictionary {
	
	String[] arr;
		/**Constructor of Dictionary, to call readFile method
		 * 
		 */
		public Dictionary(){
			readFile("words.txt");
			
		}
		
		/**
		 * 
		 * @param fileName file from other txt or sources
		 * @return return an array of String that has all of words in dictionary
		 */
		public String[] readFile(String fileName){
				
				ArrayList<String> data = new ArrayList<String>();
				// Create the scanner (open the file for reading)
				Scanner scan;
			    String line = "";
			     
			    try {
			          scan = new Scanner( new File ( "words.txt" ) );
			          
				    	while(scan.hasNext()) {
				            
				        line = scan.nextLine();
				        data.add(line);
				    	}
				    	
				    	arr = new String[ data.size() ];
				    	for( int i = 0; i < data.size(); i++) {
				    		arr[i] = data.get(i);
				    	}
				        data = null;    // all element in the arrayList has been push into the array
				   
			          
			       } catch (IOException e) {
			          System.err.println("Error reading from: " + fileName);
			          System.exit(1);
			       }
			 	return arr;
			  
			         
		}
		
	
		
		
		/**
		 * 
		 * @param data - an array of all words available for searching
		 * @param key - the word we want to find if it is in the dictionary
		 * @param start - the start point of searching
		 * @param end - the end point of searching
		 * @return return true if the word is in the dictionary, return false otherwise
		 */
		public boolean searchWord(String[] data, String key, 
			int start, int end){
			
		  int mid= start + (end-start)/2;
		  
		  if (data[mid].equals(key)) 
			  return true;
		  else if(start>end)
		  return false;
		  else if (data[mid].compareTo(key) > 0 ) {
		    return searchWord(data,key,start,mid-1);
		  }
		  else {
		    return searchWord(data,key,mid+1,end);
		  }
		  
		  
		}


	}


