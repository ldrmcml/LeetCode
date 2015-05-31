package TestQuestion.cloneable;

public class A implements Cloneable {
	public String name;
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		// shadow clone
		return super.clone();
	}
	public static void main(String[] args) throws CloneNotSupportedException{
		A a1=new A();
		A a2=new A();
		// 直接=等号赋值
		a1.name="a1";
		a2=a1;
		a2.name="a2";
		System.out.println("a1.name="+a1.name);  
		System.out.println("a2.name="+a2.name);  
		// 调用clone方法
		a1.name="a1";
		a2=(A)a1.clone();
		a2.name="a2";
		System.out.println("a1.name="+a1.name);  
		System.out.println("a2.name="+a2.name);  
	}
}
