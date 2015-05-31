package TestQuestion;

import java.math.BigInteger;

public class TestImmutable {
	public static void test1(){
		BigInteger fiveThousand=new BigInteger("5000");
		BigInteger fiftyThousand=new BigInteger("50000");
		BigInteger fiveHundredThousand=new BigInteger("500000");
		BigInteger total=BigInteger.ZERO;
		total.add(fiveThousand);
		total.add(fiftyThousand);
		total.and(fiveHundredThousand);
		System.out.println(total);
	}
	public static void test2(){
		BigInteger fiveThousand=new BigInteger("5000");
		BigInteger fiftyThousand=new BigInteger("50000");
		BigInteger fiveHundredThousand=new BigInteger("500000");
		BigInteger total=BigInteger.ZERO;
		total=total.add(fiveThousand);
		total=total.add(fiftyThousand);
		total=total.add(fiveHundredThousand);
		System.out.println(total);
	}
	public static void main(String[] args){
		test1();
		test2();
	}
}
