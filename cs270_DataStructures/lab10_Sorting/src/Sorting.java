import java.util.Random;

public class Sorting {
	private int[] myArray;
	int size = 1000;
	Random randomGenerator = new Random();

	public Sorting(){
		this.myArray= new int[size];
		for(int i=0;i<size;i++){
			int randomInt = randomGenerator.nextInt(100);
			myArray[i]=randomInt;
		}
		
		
	}
	
}




