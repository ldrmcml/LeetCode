package TestQuestion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TestIterator {
	public static void main(String[] args){
		List<Integer> list=new ArrayList<Integer>();

		for(int i=0;i<10;i++){
			list.add(i);
		}
		// java.util.ConcurrentModificationException
		//		for(int i:list){
		//			list.remove(i);
		//		}
		// 下面会抛出异常。因为你删除了元素，但是未改变迭代的下标，这样当迭代到最后一个元素就报数组越界异常
		//		for(int i=0,len=list.size();i<len;++i){
		//			if(list.get(i)==4){
		//				list.remove(i);
		//			}
		//		}
		// 改进。倒序删除。
		for(int i=list.size()-1;i>=0;i--){
			if(list.get(i)==4){
				list.remove(i);
			}
		}
		System.out.println(list);
		// 利用Iterator接口删除元素
		Iterator<Integer> ite=list.iterator();
		// 下面正确！！！
		// 使用ConcurrentHashMap不会抛出ConcurrentModificationException！！！！
		while(ite.hasNext()){
			int e=ite.next();
			if(e==3){
				ite.remove();
			}
		}
		
		// 都会产生ConcurrentModificationException！！！！
		ite=list.iterator();
		while(ite.hasNext()){
			int e=ite.next();
			if(e==0){
				//ArrayList:remove(Object o)
				//list.remove(new Integer(e));
				
				//ArrayList:remove(int index)
				list.remove(e);
			}
		}

		//It is imperative that the user manually synchronize on the returned list 
		//when iterating over it: 
		//		List list = Collections.synchronizedList(new ArrayList());
		//		...
		//		synchronized (list) {
		//			Iterator i = list.iterator(); // Must be in synchronized block
		//			while (i.hasNext())
		//				foo(i.next());
		//		}

		System.out.println(list);

		CopyOnWriteArrayList<String> clist=new CopyOnWriteArrayList<String>();
		for(int i=0;i<10;i++)
			clist.add("e "+i);
		
		// 正确的做法！！！
		for(String item:clist){
			String str=item;
			String tem=str+"...";
			clist.remove(item);
			clist.add(tem);
		}
		System.out.println(clist);
//		Iterator<String> it = clist.iterator();
//		while(it.hasNext())
//		{
//			String str = it.next();
//			String tem = str + "...";
//			// java.lang.UnsupportedOperationException
//			it.remove();
//		}
	}
}
