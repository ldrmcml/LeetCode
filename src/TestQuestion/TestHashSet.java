package TestQuestion;

import java.util.HashSet;

class Person{
	int id;
	String name;
	public Person(int id,String name){
		this.id=id;
		this.name=name;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "["+id+","+name+"]";
	}
}
public class TestHashSet {
	public static void main(String[] args){
		HashSet<Person> set=new HashSet<Person>();
		Person p1=new Person(1,"1");
		Person p2=new Person(1,"1");
		p2=p1;
		set.add(p1);
		set.add(p2);
		System.out.println(set);
	}
}
