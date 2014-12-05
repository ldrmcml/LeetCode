package TestQuestion.test;

import java.util.*;
public class TestHashmap {
	public static void main(String[] args) {
		Map<String, Integer> m = new HashMap<String, Integer>();
		Map<String, Integer> m2 = new HashMap<String, Integer>();
		
		m.put("one", 1);
		m.put("two", 2);
		m.put("three", 3);
		System.out.println( m2.isEmpty()); //true
		m2.putAll( m );
		System.out.println( m2.isEmpty()); //false
		
		System.out.println( m.put("four", 4));
		System.out.println( m.get("one"));    //1
		m.remove("one");
		System.out.println( m.put("two", 20)  );
		System.out.println( m.containsKey("four")); //true
		System.out.println(m.containsValue(2) );
		System.out.println( m.size() );   //3
		System.out.println( "m2: " + m2 );   
		
		for(Iterator<String> it=m2.keySet().iterator();it.hasNext();){
			Object key=it.next();
			System.out.println(key+":"+m2.get(key));
		}
		for(Iterator<Map.Entry<String, Integer>> it=m2.entrySet().iterator();it.hasNext();){
			Object key=it.next();
			System.out.println(key+":"+m2.get(key));
		}//two=2:null
		//one=1:null
		//three=3:null
		for(Iterator<Map.Entry<String, Integer>> it=m2.entrySet().iterator();it.hasNext();){
			Map.Entry<String, Integer> me=it.next();
			System.out.println(me.getKey()+":"+me.getValue());
		}
		if( m.containsKey("two")) {
		        int i = m.get("two");
			System.out.println(i); 		
		}
		
	
	}
}