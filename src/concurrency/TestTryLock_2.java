package concurrency;

import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class TestTryLock_2 {
	static ReentrantLock lock = new ReentrantLock();

	public static void main(String[] args) {
		ExecutorService es = Executors.newCachedThreadPool();

		es.execute(new Runnable() {

			@Override
			public void run() {
				foo("thread1");
			}
		});

		es.execute(new Runnable() {

			@Override
			public void run() {
				foo("thread2");
			}
		});
	}

	private static void foo(String threadName) {
		while(true){
			if(lock.tryLock()){
				try{
					System.out.println(Thread.currentThread().getName()+":"+lock.getHoldCount());
					System.out.println(Thread.currentThread().getName()+":"+threadName);
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) 
					{ 
						e.printStackTrace();
					}
					break;
				}finally {
					lock.unlock();
					System.out.println(Thread.currentThread().getName()+":"+lock.getHoldCount());
				}
			} 
		}
	}
}