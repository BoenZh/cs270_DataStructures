import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class InfixEvaluator {
	
	public static void main(String[] args) {
		InfixEvaluator.evaluate("7 - 3 * 2 + 7");
		
	}
	
	
	public static int evaluate( String exp ){
		Scanner go=new Scanner(exp);
		go.useDelimiter(" ");
		Stack<String> operand=new Stack<String>();
		Stack<String> operator=new Stack<String>();
		String s;
		
		
		while( go.hasNext()){
			s=go.next();
			System.out.println(s);
			if(isOperand(s))
				operand.push(s);
			
			else
				operator.push(s);
			
			
			
			
		}
		while(!operand.isEmpty()){
			System.out.println(operand.pop());
		}
		
		while(!operator.isEmpty()){
			System.out.println(operator.pop());
		}
		
		
		return 0;
	}
	
	private static boolean isOperand( String c){
		
		return c=="+" || c=="-" || c=="*" || c=="/" || c=="%" || c=="(" || c==")" || c=="^";
	}
	
	
	
	
	

}
