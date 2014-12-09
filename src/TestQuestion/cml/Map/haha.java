package TestQuestion.cml.Map;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

class Book{
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
}
public class haha {
	public static void main(String[] args){
		Book book1=new Book();
		book1.setName("yuwen");
		book1.setPrice(10);
		
		Book book2=new Book();
		book2.setName("shuxue");
		book2.setPrice(20);
		
		List<Book> list=new ArrayList<Book>();
		list.add(book1);
		list.add(book2);
		
		String str=JSON.toJSONString(list);
		JSONArray array=(JSONArray) JSONArray.toJSON(list);
		for(int i=0;i<array.size();i++)
			array.add(book2);
		System.out.println(array);
		
	}

}
