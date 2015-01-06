package TestQuestion;

import java.util.Scanner;

public class pat1031 {
	static int[] prior={7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2};
	static char[] hash={'1','0','X','9','8','7','6','5','4','3','2'};
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		boolean all=true;
		for(int count=0;count<num;count++){
			String str = sc.next();
			boolean flag = false;
			// 首先检验前17位
			for(int i=0;i<17;i++){
				if(str.charAt(i)<'0'||str.charAt(i)>'9')
				{
					System.out.println(str);
					all=false;
					flag=true;
					break;
				}
			}
			if(flag)continue;
			// 再检验校验位
			int sum = 0;
			for(int i=0;i<17;i++){
				sum+=(str.charAt(i)-'0')*prior[i];
			}
			int mod=sum%11;
			if(hash[mod]==str.charAt(17));
			else {
				System.out.println(str);
				all=false;
			}
		}
		if(all)System.out.println("All passed");
		sc.close();
	}
}
