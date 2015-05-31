package TestQuestion.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyThread extends Thread {
	public MyThread(){
		
	}
	public MyThread(String name){
		super(name);
	}
	public void run(){
		System.out.println(Thread.currentThread().getId()+" "+Thread.currentThread().getName());
	}
}
public class TestSingle {
	
	public static void main(String[] args){
		ExecutorService pool=Executors.newSingleThreadExecutor();
		
		Thread t1=new MyThread("t1");
		Thread t2=new MyThread("t2");
		Thread t3=new MyThread("t3");
		Thread t4=new MyThread("t4");
		Thread t5=new MyThread("t5");
		
		t1.start();// output:9 t1!Amazing!!
		
		pool.execute(t1);
		pool.execute(t2);
		pool.execute(t3);
		pool.execute(t4);
		pool.execute(t5);
		pool.shutdown();
	}
}
