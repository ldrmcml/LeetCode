package pat.toplevel;

import java.util.Scanner;

public class pat1001 {
	public static Scanner scan;
	public static int id[];
	public static int count;
	private static int[] sz;// 各个根节点所对应的分量的大小
	public static int find(int p){
		while(p!=id[p])
			p=id[p];
		return p;
	}
	// quick-find
	public static int find_quickfind(int p){
		return id[p];
	}
	public static void quick_find(int p, int q){
		// 将p、q所在集合合并
		int pRoot = find_quickfind(p);
		int qRoot = find_quickfind(q);
		if(pRoot == qRoot)return;
		for(int i=0;i<id.length;i++)
			if(id[i]==pRoot)id[i]=qRoot;
		// 连通分量数目减一
		count--;
	}
	// quick-union
	public static void quick_union(int p, int q){
		// 将p、q所在集合合并
		int pRoot = find(p);
		int qRoot = find(q);
		if(pRoot == qRoot)return;
		id[pRoot]=qRoot;
		// 连通分量数目减一
		count--;
	}
	// 加权quick-union
	public static void weighted_quick_union(int p, int q){
		// 将p、q所在集合合并
		int pRoot = find(p);
		int qRoot = find(q);
		if(pRoot == qRoot)return;
		// 将小树的根节点连接到大树的根节点
		if(sz[pRoot]<sz[qRoot]){id[pRoot]=qRoot;sz[qRoot]+=sz[pRoot];}
		else{id[qRoot]=pRoot;sz[pRoot]+=sz[qRoot];}
		// 连通分量数目减一
		count--;
	}
	// 路径压缩的加权quick-union
	public static int find_compressed(int p){
		int r=p;
		while(r!=id[r])
			r=id[r];
		int i=p;
		int tmp;
		while(i!=r){
			tmp=id[i];
			id[i]=r;
			i=tmp;
		}
		return r;
	}
	public static void compressed_quick_union(int p, int q){
		// 将p、q所在集合合并
		int pRoot = find_compressed(p);
		int qRoot = find_compressed(q);
		if(pRoot == qRoot)return;
		id[pRoot]=qRoot;
		// 连通分量数目减一
		count--;
	}
	public static void main(String[] args){
		scan = new Scanner(System.in);
		int n = scan.nextInt();
		while(0!=n){
			// 初始化id数组,count
			//			sz=new int[n+1];
			//			for(int i=1;i<=n;i++)
			//				sz[i]=1;// 初始大小均为1
			id = new int[n+1];
			for(int i=1;i<=n;i++)
				id[i]=i;
			count=n;

			int m = scan.nextInt();
			for(int i=0;i<m;i++){
				int p = scan.nextInt();
				int q = scan.nextInt();
				compressed_quick_union(p,q);
			}

			System.out.println(count-1);
			n = scan.nextInt();
		}
	}
}
