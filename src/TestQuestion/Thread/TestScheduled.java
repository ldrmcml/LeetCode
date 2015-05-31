package TestQuestion.Thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestScheduled {
	public static void main(String[] args){
		//		ScheduledExecutorService pool=Executors.newScheduledThreadPool(1);
		//		pool.scheduleAtFixedRate(new Runnable(){
		//			public void run(){
		//				System.out.println("=======================");
		//			}
		//		},1000,5000,TimeUnit.MILLISECONDS);
		//		pool.scheduleAtFixedRate(new Runnable(){
		//			public void run(){
		//				System.out.println(System.nanoTime());
		//			}
		//		},1000,2000,TimeUnit.MILLISECONDS);

//		ScheduledThreadPoolExecutor exec=new ScheduledThreadPoolExecutor(5);
//		exec.scheduleAtFixedRate(new Runnable(){
//			public void run(){
//				System.out.println("===========================");
//			}
//		}, 1000, 5000, TimeUnit.MILLISECONDS);
//		exec.scheduleAtFixedRate(new Runnable(){
//			public void run(){
//				System.out.println(System.nanoTime());
//			}
//		}, 1000, 2000, TimeUnit.MILLISECONDS);
		
		int i=0;i=i++;
		System.out.println(i);
	}
	public float testReturn(){
		return '2';
	}
}
