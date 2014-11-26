package generics;

import java.util.ArrayList;
import java.util.List;

public class ListOfGenerics<T> {
	private List<T> array=new ArrayList<T>();
	public void add(T item){
		array.add(item);
	}
	public T get(int index){
		return array.get(index);
	}
	public static void main(String[] args){
		ListOfGenerics<String> array=new ListOfGenerics<String>();
		array.add("hello");
		System.out.println(array.get(0));
	}
}
