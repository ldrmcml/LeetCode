package pat.advancedlevel;

import java.util.Scanner;

public class pat1024 {
	public static long reverse(long n){
		StringBuffer str1=new StringBuffer(Long.toString(n));
		StringBuffer str2=str1.reverse();
		return Long.parseLong(str2.toString());
	}
	public static boolean isPalindromic(long n){
		if(reverse(n)==n)return true;
		return false;
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		long n,k,count=0;
		n=sc.nextLong();
		k=sc.nextLong();
		if(isPalindromic(n))k=0;
		while(k>0){
			n+=reverse(n);
			count++;
			if(isPalindromic(n))break;
			k--;
		}
		System.out.println(n);
		System.out.println(count);
		sc.close();
	}
}
