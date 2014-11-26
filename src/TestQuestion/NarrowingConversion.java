package TestQuestion;

public class NarrowingConversion {
	public static void main(String[] args){
		int a=12;
		long La=13;
		a=(int) (a+La);
		short s=0x7fff;
		byte b=(byte) 127;
		System.out.println(Integer.toBinaryString(b));
	}

}
