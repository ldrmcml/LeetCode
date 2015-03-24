package TestQuestion;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class TestQueue {
	public static void show(Queue q){
		Iterator ite=q.iterator();
		while(ite.hasNext()){
			System.out.println(ite.next());
		}
	}
	public static void main(String[] args){
		Queue q=new LinkedList();
		q.add(1);
		q.add(2);
		show(q);
		int e=(int) q.poll();
		show(q);
		e=(int) q.poll();
		show(q);
		// when q is empty, poll return null and don't throw Exception.And you can't convert null
		q.poll();
		// But remove() will throw NoSuchElementException when q is empty.
		//q.remove();
		show(q);
	}
}
