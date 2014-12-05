package TestQuestion.cml.Map;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapTest {
	
	public static void main(String[] args) {

    HashMap hashmap = new HashMap();

	for (int i = 0; i <1000; i++ ) {

	hashmap.put(""+i, "thanks+"+i);

	}
	String str=hashmap.get("89").toString();
	//String str=(String)hashmap.get("89");
	System.out.println(str);

	/*Iterator iterator = hashmap.keySet().iterator();

	while (iterator.hasNext()) {

	    System.out.print(hashmap.get(iterator.next()));

	}*/

/*
		Iterator it = hashmap.entrySet().iterator();

		while (it.hasNext()) {

		Map.Entry entry = (java.util.Map.Entry) it.next();

		// entry.getKey() ����������Ӧ�ļ�

		// entry.getValue() ����������Ӧ��ֵ

		System.out.println(entry.getKey());
		System.out.println(entry.getValue());
		}*/

	}
}
