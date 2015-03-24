package pat.advancedlevel;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class pat1094 {
	// 会赋值为0
	// 邻接矩阵
	public static int[][] arr=new int[105][105];
	public static void display(int[][] arr){
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
	public static void bfs(int[][] arr,int n){
		Queue<Integer> q1=new LinkedList<Integer>();
		Queue<Integer> q2=new LinkedList<Integer>();
		int root=1;
		int lev=1,index=1;
		int cur=1;
		int max=cur;
		q1.add(root);
		while(!q1.isEmpty()){
			while(!q1.isEmpty()){
				root=q1.poll();
				int[] tmp=arr[root];
				for(int i=0;i<n+1;i++){
					if(tmp[i]==1)q2.add(i);
				}
			}
			lev++;
			cur=q2.size();
			if(cur>max){
				max=cur;
				index=lev;
			}
			q1.clear();
			q1.addAll(q2);
			q2.clear();
		}
		System.out.println(max+" "+index);
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		for(int i=0;i<m;i++){
			int id=sc.nextInt();
			int k=sc.nextInt();
			for(int j=0;j<k;j++){
				int tmp=sc.nextInt();
				arr[id][tmp]=1;
			}
		}
		bfs(arr,n);
		sc.close();
	}
}
