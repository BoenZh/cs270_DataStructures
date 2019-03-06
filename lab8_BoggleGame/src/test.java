import java.util.Random;

public class test {

	public static void main(String[] args) {
		Random a1 = new Random(),a2 = new Random();
		int go1,go2;
		
		
		for(int i=0;i<5;i++){
			go1=a1.nextInt(100);
			go2=a2.nextInt(100);
			System.out.println("go1= "+ go1 + "  go2= "+ go2);
		}
		
		

	}

}
