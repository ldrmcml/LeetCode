package TestQuestion;

enum mei{
	// 相当于构造mei对象
	HE(1),SHE(1),I(1),HER(1);
	private int i;
	private mei(int i){
		this.i=i;
	}
	public int getI(){
		return i;
	}
}
class ge{
	// 编译无法通过
//	HE(1),SHE(1),I(1),HER(1);
	private int i;
	private ge(int i){
		this.i=i;
	}
	public int getI(){
		return i;
	}
}
public class TestEnum {
	public static void main(String[] args){
		for(mei m:mei.values())
			System.out.println(m.getI());
	}
}
