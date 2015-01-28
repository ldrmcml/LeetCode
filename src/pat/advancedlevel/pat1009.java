package pat.advancedlevel;

import java.util.Scanner;

public class pat1009 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int a1[],a2[];
		double b1[],b2[];
		int k1=sc.nextInt();
		a1=new int[k1];
		b1=new double[k1];
		for(int i=0;i<k1;i++){
			a1[i]=sc.nextInt();
			b1[i]=sc.nextDouble();
		}
		int k2=sc.nextInt();
		a2=new int[k2];
		b2=new double[k2];
		for(int i=0;i<k2;i++){
			a2[i]=sc.nextInt();
			b2[i]=sc.nextDouble();
		}
		int coe[]=new int[105];
		int num=0;
		double hash[]=new double[2005];
		for(int i=0;i<2005;i++)hash[i]=0;
		for(int i=0;i<k1;i++)
			for(int j=0;j<k2;j++){
				hash[a1[i]+a2[j]]+=b1[i]*b2[j];
			}
		for(int i=0;i<hash.length;i++)
			if(0!=hash[i]){
				coe[num]=i;
				num++;
			}
		System.out.print(num);
		for(int i=num-1;i>=0;i--){
			System.out.print(" "+coe[i]);
			System.out.format(" %.1f", hash[coe[i]]);
		}
		sc.close();
	}
}
