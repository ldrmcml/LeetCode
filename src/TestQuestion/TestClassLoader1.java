package TestQuestion;

public class TestClassLoader1 {
	public static void main(String[] args){
		//引导类加载器bootstrap classloader，由C++实现
		ClassLoader cl1=TestClassLoader1.class.getClassLoader().getParent().getParent();
		System.out.println(cl1);
		//扩展类加载器Extension classloader
		ClassLoader cl2=TestClassLoader1.class.getClassLoader().getParent();
		System.out.println(cl2);
		//App ClassLoader或者叫做System classloader
		ClassLoader cl3=TestClassLoader1.class.getClassLoader();
		System.out.println(cl3);
	}
}
