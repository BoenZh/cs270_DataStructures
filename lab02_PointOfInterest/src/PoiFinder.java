/**
 *  Name: zhang boen
  Assignment: Lab 02
  Title: PoiFInder
  Course: CSCI 270
  Lab Section: 01
  Semester: Fall, 2016
  Instructor: Dr. Blaha
  Date: 9/26/16
  Sources consulted: none
  Program description: to find what you want
  Known Bugs: none
  Creativity: Instead of displaying just the closest match, display the five closest matches.
   			(5) Display them in sorted order (10).(lease than 5 then display size.)
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PoiFinder {
	
	
	/**
	 * the main program
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		Scanner infile = null;
		Scanner go =null;
		ArrayList<PointOfInterest> poiPoi=new ArrayList<PointOfInterest>();
		
		ArrayList<PointOfInterest> temp=new ArrayList<PointOfInterest>();
		
		
		ArrayList<PointOfInterest> display=new ArrayList<PointOfInterest>(5);;
		GeoLocation loc=null;
		PointOfInterest poi=null;
		PointOfInterest result=null;
		
		
		String name = null;
		String address = null;
		String tag = null;
		String userIn;
		double la=0 ;
		double lo=0 ;
		int count=0;
		int num=0;
		int displaySize=0;
		double distance=0;
		
		/**
		 * read the data from file
		 */
		try {
			infile = new Scanner(new File("placesSmall.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("File " + "placesSmall.txt" + " not found");
			System.exit(0);
		}
		String s=null;
		
		
		while(infile.hasNextLine()){
			s=infile.nextLine();
			go=new Scanner(s);
			go.useDelimiter("\t");
			name=go.next();
			address=go.next();
			tag=go.next();
			la=Double.parseDouble(go.next());
			lo=Double.parseDouble(go.next());
			
			loc=new GeoLocation(la,lo);
			poi=new PointOfInterest(name,address,tag,loc);
			poiPoi.add(poi);
			
		}
		
		
		
		Scanner keyboard=new Scanner(System.in);
	
		
		
		
		System.out.println("Enter your current latitude:");
		double latInput=keyboard.nextDouble();
		System.out.println("Enter your current longitude:");
		double lonInput=keyboard.nextDouble();
		
		System.out.println("waht are you looking for?");
		keyboard.nextLine();
		userIn=keyboard.nextLine();
		GeoLocation locationInput=new GeoLocation(latInput,lonInput);
		
		for(int i=0; i<poiPoi.size();i++){
			if(poiPoi.get(i).match(userIn)){
				temp.add(poiPoi.get(i));
				
			}
		}
		
		
		
		if(temp.size()==0){
			System.out.println("could not find the target!");
		}
		else{
			if(temp.size()<5)
				count=temp.size();
			else{
				count=5;
			}
			
			
			for(int b=0;b<count;b++){
			for(int i=0;i<temp.size();i++){
				result=temp.get(0);
				GeoLocation min=temp.get(0).getLocation();
				GeoLocation d1=temp.get(i).getLocation();
				if(d1.distanceFrom(locationInput)-(min.distanceFrom(locationInput))<0){
					result=temp.get(i);
					min=d1;
					num=i;
				}
				
				
			}// end of for loop
			display.add(result);
			temp.remove(num);
			}
			
			System.out.println("Top "+count+" nearest match:");
			System.out.println("-----------------------------");
			for(int i=0;i<count;i++){
				System.out.println(display.get(i).toString());
				GeoLocation d3=display.get(i).getLocation();
				distance=d3.distanceFrom(locationInput);
				System.out.println("Distance:  "+distance+"  miles");
				System.out.println("-----------------------------");
			}
			
			
			
			
			
			
			
		}
			
		

	}
	
	
	
	
	
	
	
	
	

}
