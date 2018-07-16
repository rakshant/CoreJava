package String;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


class Person implements Comparable<Person>{
	
	String name="";
	int height=0;
	int weight=0;
	
	public Person() {
		// TODO Auto-generated constructor stub
	}
	public Person(String name,int h,int w){
		this.name=name;
		this.height=h;
		this.weight=w;
	}

	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		Person p=(Person)o;
		if(this.height>p.height)
			return 1;
		else if(this.height<p.height)
			return -1;
		return 0;
	}
}

class NameBasedSorting implements Comparator<Person>{

	public int compare(Person o1, Person o2) {
		// TODO Auto-generated method stub
		if(o1.name.compareTo(o2.name)>0){
			return 1;
		}
		else if(o1.name.compareTo(o2.name)<0){
			return -1;
		}
		return 0;
	}
	
}

class WeightBasedSorting implements Comparator<Person>{

	@Override
	public int compare(Person o1, Person o2) {
		// TODO Auto-generated method stub
		if(o1.weight>o2.weight)
			return 1;
		else if(o1.weight<o2.weight)
			return -1;
		return 0;
	}
	
}

public class Compare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Person> list=new ArrayList<Person>();
		list.add(new Person("Ram",160,70));
		list.add(new Person("Aakash",165,60));
		list.add(new Person("shyam",150,90));
		
		Collections.sort(list);
		System.out.println("Simple Sorting");
		
		for(Person i : list){
			System.out.println(i.height);
		}
		
		Collections.sort(list,new NameBasedSorting());
		System.out.println();
		System.out.println("Name Based Sorting");
		for(Person i : list){
			System.out.println(i.name);
		}
		
		Collections.sort(list,new WeightBasedSorting());
		System.out.println();
		System.out.println("Weight Based Sorting");
		for(Person i : list){
			System.out.println(i.weight);
		}

	}

}
