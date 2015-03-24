package TestQuestion;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestInterruptedException implements Runnable {
	public void run(){
		try {
			TimeUnit.MILLISECONDS.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.err.println("Interrupted");
		}
	}
	public static void main(String[] args){
		ExecutorService exec=Executors.newCachedThreadPool();
		for(int i=0;i<5;i++){
			exec.execute(new TestInterruptedException());
		}
		exec.shutdown();
	}
}
