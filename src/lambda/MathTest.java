package lambda;

import java.util.function.BinaryOperator;


public class MathTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryOperator<Integer> bo1= (Integer a,Integer b) ->a+b;
		System.out.println(bo1.apply(4,5));
		
		BinaryOperator<Integer> bo2= (Integer a,Integer b) ->a-b;
		System.out.println(bo2.apply(4,5));
		
		BinaryOperator<Integer> bo3= (Integer a,Integer b) ->a*b;
		System.out.println(bo3.apply(4,5));
		
		BinaryOperator<Integer> bo4= (Integer a,Integer b) ->a/b;
		System.out.println(bo4.apply(10,5));		

	}

}
