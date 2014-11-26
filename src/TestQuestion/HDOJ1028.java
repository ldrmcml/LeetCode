package TestQuestion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HDOJ1028 {
	int vis[][];
	public HDOJ1028(int size){
		vis=new int[size][size];
	}
	public int fun(int n,int last){
		if(n<=1)return 1;
		if(vis[n][last]>0)return vis[n][last];
		int sum=0;
		for(int i=n;i>=1;i--)
			if(i<=last){
				vis[n-i][i]=fun(n-i,i);
				sum+=vis[n-i][i];
			}
		return sum;
	}
	public static void main(String[] args){
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String input=null;
		try {
			input=br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int n=Integer.parseInt(input);
		System.out.println(new HDOJ1028(129).fun(n, n));
	}
}
