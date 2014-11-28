package LeetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 使用迭代，利用栈代替递归
 * @author Administrator
 */
public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
    	//如果为空，则返回一个没有任何数据的空List
    	if(root==null)return new LinkedList<Integer>();
    	List<Integer> list=new LinkedList<Integer>();
    	Stack<TreeNode> stack=new Stack<TreeNode>();
    	TreeNode tmp=null;
    	stack.push(root);
    	//栈不为空
    	while(!stack.empty()){
    		TreeNode node=stack.peek();
    		//情况1：左右儿子都为空，此时儿子不存在，可以直接访问
    		//情况2：如果左右儿子都遍历完，则可以遍历根结点。在这里只需判断是否为儿子即可，因为我们的入栈关系保证了如果是父子关系则左右儿子一定都已经遍历。
    		//情况2.1：如果tmp为空，还是初始情况，此时并未遍历任何结点，仍然需要入栈儿子结点
    		if((node.left==null&&node.right==null)||(tmp!=null&&(tmp==node.left||tmp==node.right))){
    			//获取栈顶结点并弹出
    			tmp=stack.pop();
    			//遍历该无子结点
    			list.add(tmp.val);
    		}else{
    			//后序：左儿子->右儿子->根，总是先把儿子结点遍历完再遍历根
    			//先将右儿子入栈，再入栈左儿子
    			if(node.right!=null)stack.push(node.right);
    			if(node.left!=null)stack.push(node.left);
    		}
    	}
        return list;
    }
    public static void main(String[] args){
    	String a[]={"1","2","3","4","#","#","5"};
    	BinaryTreePostorderTraversal_1 bTraversal=new BinaryTreePostorderTraversal_1(a);
    	TreeNode T=bTraversal.buildTree();
    	List<Integer> list=new BinaryTreePostorderTraversal().postorderTraversal(T);
    	for(int val:list)
    		System.out.println(val);
    }
}