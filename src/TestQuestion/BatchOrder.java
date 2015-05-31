package TestQuestion;

class Goods{
	private String name;
	private int shopId;
	private int price;
	private int num;
	public Goods(String name, int price, int shopId,int num) {
		this.name = name;
		this.shopId=shopId;
		this.price = price;
		this.num=num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getShopId() {
		return shopId;
	}
	public void setShopId(int shopId) {
		this.shopId = shopId;
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
class Shop{
	Goods goods[];
	public Shop(Goods[] goods) {
		this.goods = goods;
	}
}
public class BatchOrder {
	// 将价格累加
	private Shop shops[];
	public long Handle(){
		long count=0;
		for(int i=0;i<shops.length;i++){
			for(Goods goods:shops[i].goods){
				count+=goods.getNum()*goods.getPrice();
			}
		}
		return count;
	}
}
