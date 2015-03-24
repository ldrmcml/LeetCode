package jvm;

public class ReferenceCountingGC {
	public Object instance=null;
	private static final int _1MB=1024*1024;
	private byte[] bigSize=new byte[2*_1MB];
	public static void testGC(){
		ReferenceCountingGC objA=new ReferenceCountingGC();
		ReferenceCountingGC objB=new ReferenceCountingGC();
		objA.instance=objB;
		objB.instance=objA;
		
		objA=null;
		objB=null;
		
		// 只是发出gc申请，并不一定会得到即时执行
		System.gc();
	}
	public static void main(String[] args){
		testGC();
	}
}
