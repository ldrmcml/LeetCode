package TestQuestion;

/*
* 生产者与消费者模型中，要保证以下几点：
* 生产者生产的同时消费者不能消费		生产方法加锁sychronized
* 消费者消费的同时生产者不能生产		消费方法加锁sychronized
* 共享空间空时消费者不能继续消费		消费前循环判断是否为空，空的话将该线程wait，释放锁允许其他同步方法执行
* 共享空间满时生产者不能继续生产		生产前循环判断是否为满，满的话将该线程wait，释放锁允许其他同步方法执行   
*/

//main方法
public class  ProducerConsumer
{
	public static void main(String[] args) 
	{
		AppleBox ab = new AppleBox();
		Producer p = new Producer(ab);
		Consumer c = new Consumer(ab);
		Thread tp = new Thread(p);
		Thread tc = new Thread(c);
		tp.start();
		tc.start();
	}
}

// 苹果类
class Apple
{
	private int id;
	
	Apple(int id){
		this.setId(id);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}

// 苹果箱子
class AppleBox
{
	Apple ab[] = new Apple[5];
	int index = 0;
	
	// 放置苹果
	public synchronized void push(Apple a){
		try{
			while(index == ab.length){
				System.out.println("箱子满了");
				this.wait();
			}
			this.notify();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		ab[index] = a;
		index++;
		System.out.println("共" + index + "个苹果");
	}

	// 取苹果
	public synchronized Apple pop(){
		try{
			while(index == 0){
				System.out.println("没有苹果了");
				this.wait();
			}
			this.notify();
		}catch(Exception e){
			e.printStackTrace();
		}
		index--;
		System.out.println("还剩" + index + "个苹果");
		return ab[index];
	}
}

class Producer implements Runnable
{
	AppleBox ab = new AppleBox();
	Producer(AppleBox ab){
		this.ab = ab;
	}

	// 放置苹果
	public void run(){
		// 模拟100次
		for(int i = 0;i < 100;i++){
			Apple a = new Apple(i);
			ab.push(a);
			try{
				// 间歇随机时间
				Thread.sleep((int)(Math.random()*500));
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}

class Consumer implements Runnable
{
	AppleBox ab = new AppleBox();
	Consumer(AppleBox ab){
		this.ab = ab;
	}

	// 取出苹果
	public void run(){
		// 模拟100次
		for(int i = 0;i < 100;i++){
			Apple a = ab.pop();
			try{
				// 间歇随机时间
				Thread.sleep((int)(Math.random()*1000));
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}