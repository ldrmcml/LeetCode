package TestQuestion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestIterator {
	public static void main(String[] args){
		List<Integer> list=new ArrayList<Integer>();
		for(int i=0;i<10;i++){
			list.add(i);
		}
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
		while(ite.hasNext()){
			int e=ite.next();
			if(e==3){
				ite.remove();
			}
		}
		System.out.println(list);
	}
}
