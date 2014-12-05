package TestQuestion.test;

import java.util.ArrayList;

public class MyStack {
	private ArrayList al=new ArrayList();
	//push
	//数组溢出？
	public void push(Object e){
		al.add(e);
	}
	//pop
	//数组已经为空？
	public Object pop() throws Exception{
		if(al.isEmpty())throw new Exception("empty");
		Object object=al.get(al.size()-1);
		al.remove(al.size()-1);
		return object;
	}
	//peek
	public Object peek() throws Exception{
		if(al.isEmpty())throw new Exception("empty");
		return al.get(al.size()-1);
	}
}
