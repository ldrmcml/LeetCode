package pat.advancedlevel;

import java.util.Scanner;

public class pat1011 {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		char[] s={'W','T','L'};
		double cur=0.0;
		double tmp=0.0;
		int f[]=new int[3];
		int j;
		double pro=1.0;
		for(j=0;j<3;j++){
			cur=0.0;
			for(int i=0;i<3;i++){
				tmp=sc.nextDouble();
				if(tmp>cur){cur=tmp;f[j]=i;}
			}
			pro=pro*cur;
		}
		pro=(pro*0.65-1)*2;
		for(int i=0;i<3;i++)
			System.out.print(s[f[i]]+" ");
		System.out.format("%.2f", pro);
		sc.close();
	}
}
