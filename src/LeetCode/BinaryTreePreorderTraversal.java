package LeetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list=new LinkedList<Integer>();
		if(root==null)return list;
		Stack<TreeNode> stack=new Stack<TreeNode>();
		stack.push(root);
		while(!stack.empty()){
			TreeNode node=stack.pop();
			list.add(node.val);
			//先入栈左儿子，再入栈右儿子，达到先遍历左儿子的目的
			if(node.right!=null)stack.push(node.right);
			if(node.left!=null)stack.push(node.left);
		}
        return list;
    }
	public static void main(String[] args){
    	String a[]={"1","2","3","4","#","#","5"};
    	BinaryTreePostorderTraversal_1 bTraversal=new BinaryTreePostorderTraversal_1(a);
    	TreeNode T=bTraversal.buildTree();
    	List<Integer> list=new BinaryTreePreorderTraversal().preorderTraversal(T);
    	for(int val:list)
    		System.out.println(val);
    }
}
