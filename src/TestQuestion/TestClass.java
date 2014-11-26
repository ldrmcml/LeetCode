package TestQuestion;

import java.lang.reflect.Constructor;

public class TestClass {
	public static void main(String[] args){
		try{
			
			//returns the Constructor object of the public constructor
			Class cls[]=new Class[]{String.class};
			Object[] objs={"Hello"};
			Constructor c=String.class.getConstructor(cls);
			System.out.println(c);
			String str=(String)c.newInstance(objs);
			System.out.println(str);
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
