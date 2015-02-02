package TestQuestion;

import java.util.Scanner;

public class Jiudu1009 {
	private static int index;
	class node{
		private Integer data;
		private node left, right;
		public node(int data){
			this.data=data;
		}
		public Integer getData() {
			return data;
		}
		public void setData(Integer data) {
			this.data = data;
		}
		public node getLeft() {
			return left;
		}
		public void setLeft(node left) {
			this.left = left;
		}
		public node getRight() {
			return right;
		}
		public void setRight(node right) {
			this.right = right;
		}
	}
	// 插入新节点
	public node insert(node head, int x){
		if(null==head)return new node(x);
		int data=head.data;
		if(x<data)
			head.left=insert(head.left, x);
		else if(x>data)
			head.right=insert(head.right, x);
		return head;
	}
	// 建立二叉查找树
	public node createMain(int arr[]){
		node head=null;
		for(int i=0;i<arr.length;i++)
			head=insert(head, arr[i]);
		return head;
	}
	// 前序遍历
	public void pre(int search[], node head){
		if(null==head)return;
		search[index++]=head.data;
		pre(search, head.left);
		pre(search, head.right);
	}
	// 序列比较
	public boolean cmp(int s1[], int s2[]){
		for(int i=0;i<s1.length;i++)
			if(s1[i]!=s2[i])return false;
		return true;
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int i,j,len=0;
		Jiudu1009 bst=new Jiudu1009();
		while(true){
			int n=sc.nextInt();
			if(n==0)break;
			
			String n1;
			n1=sc.next();
			len=n1.length();
			int s1[]=new int[len],s2[]=new int[len];

			for(i=0;i<len;i++)
				s1[i]=n1.charAt(i)-'0';

			int r1[]=new int[len],r2[]=new int[len];
			node h1=bst.createMain(s1);
			index=0;
			bst.pre(r1, h1);

			for(i=0;i<n;i++){
				String n2=sc.next();
				for(j=0;j<len;j++)
					s2[j]=n2.charAt(j)-'0';

				node h2=bst.createMain(s2);
				index=0;
				bst.pre(r2, h2);
				boolean b=bst.cmp(r1, r2);
				if(b)
					System.out.println("YES");
				else
					System.out.println("NO");
			}
		}
		sc.close();
	}
}
