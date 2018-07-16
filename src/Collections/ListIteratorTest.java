package Collections;

import java.util.ArrayList;
import java.util.ListIterator;

public class ListIteratorTest {

	public static void main(String[] args) {
		
		ArrayList<Integer> ary=new ArrayList<Integer>();
		ary.add(15);
		ary.add(55);
		ary.add(25);
		ary.add(35);
		
		ListIterator<Integer> litr=ary.listIterator(ary.size());
		
		while(litr.hasPrevious()){
			
			System.out.println(litr.previous());
		}

	}

}
