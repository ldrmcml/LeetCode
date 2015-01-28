package TestQuestion;
/**
 * @author cml
 * 主要测试ArrayList的拷贝构造函数和clone()方法是否深拷贝，经测试均为浅拷贝
 */
import java.util.ArrayList;
class Node {
	private int data;
	public Node(int data){
		this.data = data;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+" data:"+data+"\n";
	}
}
public class TestArrayListConstructor {
	public static void main(String args[]){
		ArrayList<Node> src = new ArrayList<Node>();
		src.add(new Node(1));
		src.add(new Node(2));
		ArrayList<Node> dest = new ArrayList<Node>(src);
		dest.get(0).setData(3);
		System.out.println(src+""+dest);
		src.get(0).setData(1);
		System.out.println(src+""+dest);
//		ArrayList<Node> dest1 = (ArrayList<Node>) src.clone();
//		dest1.get(0).setData(4);
//		System.out.println(src+""+dest+dest1);
	}
}
