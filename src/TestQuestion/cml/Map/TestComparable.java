package TestQuestion.cml.Map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

class Record implements Comparable<Record>{
	private String name;
	private int price;
	
	public String getName(){
		return this.name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int compareTo(Record o){
		return o.price-price;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return price+"";
	}
}
public class TestComparable {
	public static void main(String[] args){
		Record book1=new Record();
		book1.setName("yuwen");
		book1.setPrice(10);
		
		Record book2=new Record();
		book2.setName("shuxue");
		book2.setPrice(20);
		
		List<Record> list=new ArrayList<Record>();
		list.add(book1);
		list.add(book2);
		
		Collections.sort(list);
		System.out.println(list);
//		String str=JSON.toJSONString(list);
//		JSONArray array=(JSONArray) JSONArray.toJSON(list);
//		for(int i=0;i<array.size();i++)
//			array.add(book2);
//		System.out.println(array);
		
	}

}
