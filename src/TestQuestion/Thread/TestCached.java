package TestQuestion.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestCached {
	public static void main(String[] args){
		ExecutorService pool=Executors.newCachedThreadPool();
		
		for(int i=0;i<10240;i++){
			Thread t=new MyThread();
			pool.execute(t);
		}
		
		Thread t1=new MyThread();
		Thread t2=new MyThread();
		Thread t3=new MyThread();
		Thread t4=new MyThread();
		Thread t5=new MyThread();
		
		pool.execute(t1);
		pool.execute(t2);
		pool.execute(t3);
		pool.execute(t4);
		pool.execute(t5);
		
		pool.shutdown();
	}
}
