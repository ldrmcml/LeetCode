package designpattern.FactoryMethod;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ShowIterator {
	public static void main(String[] args){
		List<String> list=Arrays.asList(new String[]{
				"fountain","rocket","sparkler"
		});
		Iterator<String> iter=list.iterator();
		System.out.println(iter.getClass().getName());
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
	}
}
