package TestQuestion;

class Bill{
	
}
class PhoneBill extends Bill{
	
}
class GasBill extends Bill{
	
}
public class TestPolymorphic {
	public double calculate(PhoneBill bill){
		//TODO 电话账单
		return 0.0;
	}
	public double calculate(GasBill bill){
		//TODO 燃气账单
		return 0.0;
	}
	public double calculate(Bill bill){
		if(bill instanceof PhoneBill){
			// 电话账单
		}
		if(bill instanceof GasBill){
			// 燃气账单
		}
		return 0.0;
	}
	public static void main(String[] args){
		PhoneBill phoneBill=new PhoneBill();
		TestPolymorphic testPolymorphic=new TestPolymorphic();
		// 利用了面向对象编程的多态特性polymorphic
		testPolymorphic.calculate(phoneBill);
	}
}
