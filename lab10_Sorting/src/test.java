

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		Random rand=new Random();
		ArrayList<Integer> temp=new ArrayList<Integer>();
		
		
		int input=9;
		int dataPoint=0;
		
		Scanner scan=new Scanner(System.in);
		while(input<0||input>8){
			System.out.println("1) Selection Sort");
			System.out.println("2) Insertion Sort");
			System.out.println("3) Bubble Sort");
			System.out.println("4) Shell Sort ");
			System.out.println("5) Merge Sort ");
			System.out.println("6) Heapsort");
			System.out.println("7) Quicksort");
			System.out.println("8) Quit");
			System.out.println("Please select an option:");
			input=scan.nextInt();
			if(input<0||input>9)
				System.out.println("input an int from 1 to 8");
			if(input==8)
				System.exit(0);
		}
		
		System.out.println("please input the data size(any int smaller than 10 or over 1000 will be convert to 10):");
		dataPoint=scan.nextInt();
		if(dataPoint<10||dataPoint>1000)
			dataPoint=10;
		Integer[] data=new Integer[dataPoint];
		for(int i=0;i<dataPoint;i++){
			data[i]=rand.nextInt(3000);
		}
		
		

	}
	
	private static int aveTime(ArrayList<Integer> a){
		
		
		
		return 0;
	}

}
