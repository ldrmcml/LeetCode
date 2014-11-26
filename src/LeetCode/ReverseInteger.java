package LeetCode;

//import java.util.Stack;
//Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. 
//如何处理溢出？
//1、抛出异常      2、返回最大最小值
public class ReverseInteger {
	public int reverse(int x) throws Exception {
		//Stack<Integer> stack=new Stack<Integer>();
		int flag=1,yushu,sum=0;
		if(x<0){
			x=-x;
			flag=-1;
		}
		//截取整数部分
		//int digits=(int)Math.log10(x);
		while(x!=0){
			yushu=x%10;
			//overflow check.
			//if(yushu/10+sum>Integer.MAX_VALUE/10)
			if(sum!=0&&yushu/sum+10>Integer.MAX_VALUE/sum)
				//return flag>0?Integer.MAX_VALUE:Integer.MIN_VALUE;
				throw new Exception("overflow");
			sum=yushu+sum*10;
			x/=10;
		}
		//在这里判断不行，永远不会出现这样的情况
		//if(sum>Integer.MAX_VALUE)return 0;
		return flag*sum;
	}
	public static void main(String[] args){
		int x=1000000003;
		try {
			System.out.println(new ReverseInteger().reverse(x));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
