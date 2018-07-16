package Collections;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;


class Person {
	int weight;
	int height;
	String name;
	public Person(int weight, int height, String name) {
		super();
		this.weight = weight;
		this.height = height;
		this.name = name;
	}
	public String toString(){
		return name+"  "+height+"  "+weight;
		
	}
	
}

class PersonComparator implements Comparator<Person>{

	@Override
	public int compare(Person o1, Person o2) {
		if(o1.weight>o2.weight)
			return 1;
		else if(o1.weight<o2.weight)
			return -1;
		else if(o1.weight==o2.weight){
			if(o1.height>o2.height)
				return 1;
			else if(o1.height<o2.height)
				return -1;
		}
		return 0;
	}
	
	
}


public class TreesetTest {

	public static void main(String[] args) {
		
		TreeSet<Person> ts=new TreeSet<Person>(new PersonComparator());
		ts.add(new Person(50,175,"Tom"));
		ts.add(new Person(60,185,"Alex"));
		ts.add(new Person(65,165,"Yash"));
		ts.add(new Person(65,172,"Sam"));

		System.out.println("Weight and height based Sorting");
	
		Iterator<Person> itr=ts.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
		
	}

}
