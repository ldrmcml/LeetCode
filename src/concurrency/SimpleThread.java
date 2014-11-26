package concurrency;

public class SimpleThread extends Thread {
	private int countDown=5;
	private static int threadCount=0;
	public SimpleThread(){
		//store the thread name;
		//调用父类Thread构造方法Thread(String name) 
		super(Integer.toString(++threadCount));
		start();
	}
	public String toString(){
		//Thread方法 String	getName() 
        //Returns this thread's name.
		return "#"+getName()+"("+countDown+").";
	}
	public void run(){
		while(true){
			System.out.print(this);
			if(--countDown==0)
				return;
		}
	}
	public static void main(String[] args){
		for(int i=0;i<5;i++)
			new SimpleThread();
	}

}
