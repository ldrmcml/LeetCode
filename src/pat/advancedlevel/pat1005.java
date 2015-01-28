package pat.advancedlevel;

import java.util.Scanner;

public class pat1005 {
	public static final String[] hash = {"zero","one","two","three","four","five","six","seven","eight","nine"};
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		String str = scanner.next();
		int sum = 0 ;
		for(int i = 0 ;i<str.length();i++)
			sum+=str.charAt(i)-'0';
		String sums = Integer.toString(sum);
		System.out.print(hash[sums.charAt(0)-'0']);
		for(int i=1;i<sums.length();i++)
			System.out.print(" "+hash[sums.charAt(i)-'0']);
		scanner.close();
	}
}
