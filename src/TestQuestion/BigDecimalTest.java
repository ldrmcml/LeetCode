package TestQuestion;

import java.math.BigDecimal;

public class BigDecimalTest {
	public static void main(String[] args){
		BigDecimal bigNumber = new BigDecimal("89.1234567890123456789");
		BigDecimal bigRate = new BigDecimal(1000);
		BigDecimal bigResult = new BigDecimal(0);
		bigResult = bigNumber.multiply(bigRate);
		System.out.println(bigResult);
		double dData = bigResult.doubleValue();
		System.out.println(dData);
	}
}
