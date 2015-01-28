package pat.advancedlevel;

import java.util.Scanner;

public class pat1010 {
	public static long s2decimal(String str, long radix){
		long digit, sum=0;
		// 必须判断每一位是否小于radix
		for(int i=0;i<str.length();i++){
			digit=c2int(str.charAt(i));
			if(digit>=radix)return -1;
			sum=radix*sum+digit;
		}
		return sum;
	}
	public static int c2int(char c){
		if('0'<=c&&c<='9')
			return c-'0';
		else
			return c-'a'+10;
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		String str1=sc.next();
		String str2=sc.next();
		String str=null;
		int tag=sc.nextInt();
		long radix=sc.nextLong();
		long sum=0;
		if(tag==1){
			sum=s2decimal(str1, radix);
			str=str2;
		}else if(tag==2){
			sum=s2decimal(str2, radix);
			str=str1;
		}
		// 二分查找。理性思考得出判断：2<=radix<=sum+1
		// 输出最小进制
		// only one digit,there exists multiple situations
		if(str.length()==1&&c2int(str.charAt(0))==sum){
			System.out.println(c2int(str.charAt(0))+1);
			sc.close();
			return;
		}
		long low=2,high=sum+1;
		while(low<=high){
			long num=s2decimal(str, (low+high)/2);
			if(num==-1||num<sum)
				low=(low+high)/2+1;
			else if(num>sum)
				high=(low+high)/2-1;
			else if(num==sum){
				System.out.println((low+high)/2);
				sc.close();
				return;
			}
		}
		System.out.println("Impossible");
		sc.close();
	}
}
