package pat.advancedlevel;

import java.util.Scanner;

public class pat1043 {
	public static int index;
	class Node{
		int data;
		Node left,right;
		public Node(int data){
			this.data=data;
		}
	}
	// 在二叉排序树插入新节点，返回根节点
	public Node insert(Node root, int data){
		if(null==root)
			return new Node(data);
		if(data<root.data)
			root.left=insert(root.left, data);
		else if(data>=root.data)
			root.right=insert(root.right, data);
		return root;
	}
	// 创建二叉排序树
	public Node create(int[] arr){
		Node root=null;
		for(int data:arr)
			root=insert(root, data);
		return root;
	}
	// 镜像遍历，逆先序遍历
	public void mirror(Node root, int arr[]){
		if(null==root)return;
		arr[index++]=root.data;
		mirror(root.right, arr);
		mirror(root.left, arr);
	}
	// 镜像后序遍历，逆后序遍历
	public void mirrorPost(Node root, int arr[]){
		if(null!=root.right)mirrorPost(root.right, arr);
		if(null!=root.left)post(root.left, arr);
		arr[index++]=root.data;
	}
	// 先序遍历
	public void pre(Node root, int arr[]){
		if(null==root)return;
		arr[index++]=root.data;
		pre(root.left, arr);
		pre(root.right, arr);
	}
	// 判断序列是否相同
	public boolean cmp(int arr1[], int arr2[]){
		for(int i=0;i<arr1.length;i++)
			if(arr1[i]!=arr2[i])return false;
		return true;
	}
	// 后序遍历
	public void post(Node root, int arr[]){
		if(null!=root.left)post(root.left, arr);
		if(null!=root.right)post(root.right, arr);
		arr[index++]=root.data;
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<arr.length;i++)
			arr[i]=sc.nextInt();
		pat1043 instance=new pat1043();
		Node root=instance.create(arr);
		int arr1[]=new int[n];
		index=0;instance.pre(root, arr1);
		int arr2[]=new int[n];
		index=0;instance.mirror(root, arr2);

		if(instance.cmp(arr, arr1)){
			System.out.println("YES");

			int arr3[]=new int[n];
			index=0;instance.post(root, arr3);
			System.out.print(arr3[0]);
			for(int i=1;i<arr3.length;i++)
				System.out.print(" "+arr3[i]);
		}
		else if(instance.cmp(arr, arr2)){
			System.out.println("YES");

			int arr3[]=new int[n];
			index=0;instance.mirrorPost(root, arr3);
			System.out.print(arr3[0]);
			for(int i=1;i<arr3.length;i++)
				System.out.print(" "+arr3[i]);
		}
		else
			System.out.println("NO");
		sc.close();
	}
}
