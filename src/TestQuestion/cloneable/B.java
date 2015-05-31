package TestQuestion.cloneable;

public class B implements Cloneable {
	public String[] names;
	public B(){
		names=new String[2];
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		// deep clone
		B b=(B) super.clone();
		b.names=names.clone();
		return b;
	}
	public static void main(String[] args) throws CloneNotSupportedException{
		B b1=new B();
		b1.names[0]="b1_0";
		B b2=(B) b1.clone();
		b2.names[0]="b2_0";
		System.out.println(b1.names[0]);
		System.out.println(b2.names[0]);
	}
}
