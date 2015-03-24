package pat.advancedlevel;

import java.util.Arrays;
import java.util.Scanner;

public class pat1023 {
	public static boolean com(String str1, String str2){
		// 貌似包含0也是允许的
		//if(!pan(str1))return false;
		if(str1.length()!=str2.length())return false;
		int len=str1.length();
		int[] a1=new int[len];
		for(int i=0;i<len;i++)
			a1[i]=str1.charAt(i)-'0';
		int[] a2=new int[len];
		for(int i=0;i<len;i++)
			a2[i]=str2.charAt(i)-'0';
		Arrays.sort(a1);Arrays.sort(a2);
		for(int i=0;i<len;i++){
			if(a1[i]!=a2[i])return false;
		}
		return true;
	}
	public static boolean pan(String str){
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)=='0')return false;
		}
		return true;
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		int len=str.length();
		if(len==1){
			System.out.println("No");
			System.out.println(Long.parseLong(str)*2);
			sc.close();
			return;
		}
		String str1=str.substring(0, len/2);
		String str2=str.substring(len/2);
		long a=Long.parseLong(str1),b=Long.parseLong(str2);
		long A=2*a,B=2*b;
		long chu=(long)Math.pow(10, str2.length());
		A+=B/chu;// 进位
		B%=chu;
		String strDouble=Long.toString(A)+Long.toString(B);
		if(com(str, strDouble)){
			System.out.println("Yes");
		}else{
			System.out.println("No");
		}
		System.out.println(strDouble);
		sc.close();
	}
}
