package generics;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayMaker<T> {
	private Class<T> kind;
	public ArrayMaker(Class<T> kind){
		this.kind=kind;
	}
	@SuppressWarnings("unchecked")
	T[] create(int size){
		//kind被擦除为Class
		T[] array=(T[])Array.newInstance(kind, size);
		Array.set(array, 5, "hello");
		return array;
	}
	public static void main(String[] args){
		ArrayMaker<String> stringMaker=new ArrayMaker<String>(String.class);
		String[] stringArray=stringMaker.create(9);
		//输出为null
		System.out.println(Arrays.toString(stringArray));
	}

}
