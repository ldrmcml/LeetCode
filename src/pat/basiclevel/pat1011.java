package pat.basiclevel;

import java.util.Scanner;

public class pat1011 {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int i,N;
		double A,B,C;
		N=sc.nextInt();
		//System.out.println(N);
		for(i=1;i<=N;i++){
			A=sc.nextInt();
			B=sc.nextInt();
			C=sc.nextInt();	
			if(A+B>C)
				System.out.println("Case #"+i+": true");	
			else
				System.out.println("Case #"+i+": false");
		}
		sc.close();
	}
}

