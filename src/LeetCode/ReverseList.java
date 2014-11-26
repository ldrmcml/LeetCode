package LeetCode;
//反转单向链表
//记住：这儿必须返回head，java是以值的形式传递地址，对head的修改必须作为返回值返回才有效！！！！
public class ReverseList {
	public ListNode reverse(ListNode head){
		//如果链表为空或者只有一个结点，则不需要进行任何操作
		if(head==null||head.next==null)return head;
		ListNode node=head.next;
		head.next=null;
		while(node!=null){
			//tmp保存当前结点
			ListNode tmp=node.next;
			//node的下一结点指向node自身
			node.next=head;
			head=node;
			//将下一结点tmp赋值给node
			node=tmp;
		}
		return head;
	}
	public static void main(String[] args){
    	int[] arr=new int[]{-1,2,-4,9,3,11,13,0};
    	ListNode head=new ListNode(arr[0]),node=head;;
    	for(int i=1;i<arr.length;i++){
    		node.next=new ListNode(arr[i]);
    		node=node.next;
    	}
    	node=new ReverseList().reverse(head);
    	while(node!=null){
    		System.out.print(node.val+" ");
    		node=node.next;
    	}
    }

}
