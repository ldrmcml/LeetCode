package pat.advancedlevel;

import java.util.Scanner;

public class pat1027 {
	public static char con1(int n){
		if(n<10)
			return (char)(n-0+'0');
		else
			return (char)(n-10+'A');
	}
	public static String con(int n){
		int shi=n/13;
		int ge=n%13;
		StringBuffer sb=new StringBuffer();
		sb.append(con1(shi)).append(con1(ge));
		return sb.toString();
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int r=sc.nextInt();
		int g=sc.nextInt();
		int b=sc.nextInt();
		System.out.println("#"+con(r)+con(g)+con(b));
		sc.close();
	}
}
