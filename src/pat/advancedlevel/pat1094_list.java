package pat.advancedlevel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class pat1094_list {
	// 邻接表
	public static List[] arr;
	public static void display(int[][] arr){
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
	public static void bfs(List[] arr){
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
				List tmp=arr[root];
				if(null!=tmp)
					q2.addAll(tmp);
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

		arr=new List[n+1];
		for(int i=0;i<m;i++){
			int id=sc.nextInt();
			int k=sc.nextInt();
			arr[id]=new ArrayList<Integer>();
			for(int j=0;j<k;j++){
				int tmp=sc.nextInt();
				arr[id].add(tmp);
			}
		}
		bfs(arr);
		sc.close();
	}
}
