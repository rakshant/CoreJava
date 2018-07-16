package Collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class OrderingTest {

	public static void main(String[] args) {
		HashSet<Integer> hs=new HashSet<Integer>();
		hs.add(10);
		hs.add(15);
		hs.add(55);
		hs.add(25);
		hs.add(35);
		hs.add(35);
		
		System.out.println("Unordered Hashset-");
		Iterator<Integer> itr=hs.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
		
		LinkedHashSet<Integer> lhs=new LinkedHashSet<Integer>();
		lhs.add(10);
		lhs.add(15);
		lhs.add(55);
		lhs.add(25);
		lhs.add(35);
		
		System.out.println("Ordered LinkedHashSet-");
		Iterator<Integer> itr2=lhs.iterator();
		while(itr2.hasNext()){
			System.out.println(itr2.next());
		}
		
	}

}
