package generics;

import java.util.ArrayList;

public class ErasedTypedEquivalence {
	public static void main(String[] args){
		Class c1=new ArrayList<String>().getClass();
		Class c2=new ArrayList<Integer>().getClass();
		//被擦除成它们的“原生类型”，即List
		System.out.println(c1==c2);
	}
}
