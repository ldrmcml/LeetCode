package LeetCode;

import java.util.Scanner;

public class IntegertoRoman {
	public static String intToRoman(int num) {
		int values[]={1000,900,500,400,100,90,50,40,10,9,5,4,1};
		String rom[]={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
		
		// [1,3999]
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<values.length;i++){
			while(num>=values[i]){
				sb.append(rom[i]);
				num-=values[i];
			}
		}
		return sb.toString();
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		System.out.println(intToRoman(num));
		sc.close();
	}
}
