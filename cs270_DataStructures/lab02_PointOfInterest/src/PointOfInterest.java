import java.util.Scanner;

public class PointOfInterest {
	private String name;
	private String address;
	private String tag;
	private GeoLocation location;
	
	/**
	 * super
	 * @param name
	 * @param address
	 * @param tag
	 * @param location
	 */
	public PointOfInterest(String name, String address, String tag, GeoLocation location) {
		super();
		this.name = name;
		this.address = address;
		this.tag = tag;
		this.location = location;
	}
	
	/**
	 * to do the match
	 * @param search the match target
	 * @return search could find or not
	 */
	public boolean match(String search){
		
		boolean result=false;
		Scanner check =null;
		String s=this.getTag();
		check=new Scanner(s);;
		check.useDelimiter(", ");
		while(check.hasNext()){
		if(check.next().equalsIgnoreCase(search))
			result=true;
		else{
		result= false;
		}
		}//end of while
		
		if(search.equalsIgnoreCase(name))
			result= true;
		return result;
	}
	
	/**
	 * to check how far it take
	 * @param spot the check distance
	 * @return
	 */
	public double distanceFrom (GeoLocation spot){
		return location.distanceFrom(spot);
	}
	/**
	 * the toString method
	 */
	public String toString() {
		return "Name:   "+name+"	"+"Address:   "+address+"	"+"tags:    "+tag;
	}
	
	
	
	

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @return the tag
	 */
	public String getTag() {
		return tag;
	}

	/**
	 * @return the location
	 */
	public GeoLocation getLocation() {
		return location;
	}
	
	
	
	
		
		
	
		
	
	
	
	

}
