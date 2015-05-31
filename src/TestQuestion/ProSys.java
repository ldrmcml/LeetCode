package TestQuestion;

class ServiceType{
	private String name;
	private int price;
	private int num;
	public ServiceType() {
	}
	public ServiceType(String name, int price, int num) {
		this.name = name;
		this.price = price;
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
}
class Protect {
	//7种套餐
	private ServiceType sType[]=new ServiceType[7];
}
public class ProSys {
	//1500家
	public static Protect[] pArr=new Protect[1500];
	public static void main(String[] args){
		
		
	}
}
