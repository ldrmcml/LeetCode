package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class TestTryLock_1 {
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
		try {
			//可以被中断 
			lock.tryLock();
			//Queries the number of holds on this lock by the current thread. 
			//当前线程
			System.out.println(lock.getHoldCount());
			System.out.println(threadName);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} finally {
			//Throws:
			//IllegalMonitorStateException - if the current thread does not hold this lock
			//上面的tryLock有可能根本就没有获取锁
			lock.unlock();
			System.out.println(lock.getHoldCount());
		}
	}
}
