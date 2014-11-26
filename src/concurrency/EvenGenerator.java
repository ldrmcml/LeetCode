package concurrency;

public class EvenGenerator extends IntGenerator {
	private int currentEvenValue=0;
	public int next(){
		++currentEvenValue;
		Thread.yield();//加速发现发现程序输出非偶数，可以注释掉
		++currentEvenValue;
		return currentEvenValue;
	}
	public static void main(String[] args){
		EvenChecker.test(new EvenGenerator());
	}

}
