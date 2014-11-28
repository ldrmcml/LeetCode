package LeetCode;

import java.util.LinkedList;
import java.util.List;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
/**
 * public void postorderTraversal(TreeNode root)
 * 改变了方法签名无法通过验证
 * 使用了递归
 * @author Administrator
 *
 */
public class BinaryTreePostorderTraversal_1 {
	public List<Integer> list;
	int mark;
	String a[];
	public BinaryTreePostorderTraversal_1(String[] a){
		this.a=a;
		this.mark=0;
		this.list=new LinkedList<Integer>();
	}
    public void postorderTraversal(TreeNode root) {
    	if(root==null)return;
    	postorderTraversal(root.left);
    	postorderTraversal(root.right);
    	list.add(root.val);
        return;
    }
    //先序建树
    //建树心得：1、对于C++可以传引用作为函数参数，则为这种情况void buildTree(TreeNode& T);无返回至而有参
    //2、对于C或者Java(Java以传值的形式传递地址)则为TreeNode buildTree();有返回值而无参；
    public TreeNode buildTree(){
    	if(mark>=a.length)return null;
    	if(a[mark].equals("#")){
    		mark++;
    		return null;//-1表示空
    	}
    	TreeNode T=new TreeNode(Integer.parseInt(a[mark++]));
    	T.left=buildTree();
    	T.right=buildTree();
    	return T;
    }
    public static void main(String[] args){
    	String a[]={"1","#","2","3"};
    	BinaryTreePostorderTraversal_1 bTraversal=new BinaryTreePostorderTraversal_1(a);
    	TreeNode T=bTraversal.buildTree();
    	bTraversal.postorderTraversal(T);
    	for(int val:bTraversal.list)
    		System.out.println(val);
    }
}