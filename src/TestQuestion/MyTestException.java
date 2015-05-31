package TestQuestion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

class FatherException{
	// 如果未加修饰符，表示protected
	private void test() throws FileNotFoundException{
		File file=new File("exception.txt");
		FileInputStream fis=new FileInputStream(file);
	}
}
public class MyTestException extends FatherException {
	void test() throws FileNotFoundException{
		System.out.println(2);
	}
	public void test1(int a, String...strArr){
		System.out.println(a);
		for(String str:strArr)
			System.out.println(str);
	}
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Class<?> clazz=Class.forName("TestQuestion.MyTestException");
		// 仅限public方法
		//Method method=clazz.getMethod("test");
		//		Method method1=clazz.getMethod("test", new Class[]{Integer.class});
		//System.out.println(method);
		//		System.out.println((int.class).getModifiers());// 1041
		//		test1();
		// 仅限public方法
		//		for(Method m:clazz.getMethods())
		//			System.out.println(m);
		//		System.out.println(clazz.getModifiers());
		//		System.out.println(Modifier.PRIVATE);
		Method m=clazz.getMethod("test1", int.class, String[].class);
		System.out.println(m);
		Object o=clazz.newInstance();
		m.invoke(o, 2, new String[]{"1"});
	}
}
