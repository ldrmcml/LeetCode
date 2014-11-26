package LeetCode;

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1==null)return l2;
		ListNode node1=l1,node2=l2;
		int jinwei=0,sum=0;
		ListNode tmp=null;
		//以l1为合并后的链表
		while(node1!=null&&node2!=null){
			sum=node1.val+node2.val+jinwei;
			node1.val=sum%10;
			jinwei=sum/10;
			tmp=node1;
			node1=node1.next;
			node2=node2.next;
		}
		
		if(node1==null&&node2!=null){
			tmp.next=node2;
			ListNode node=node2;
			while(jinwei!=0&&node!=null){
				sum=node.val+jinwei;
				jinwei=sum/10;
				node.val=sum%10;
				tmp=node;
				node=node.next;
			}
			if(node==null&&jinwei!=0)tmp.next=new ListNode(jinwei);
		}else if(node1!=null&&node2==null){
			ListNode node=node1;
			while(jinwei!=0&&node!=null){
				sum=node.val+jinwei;
				jinwei=sum/10;
				node.val=sum%10;
				tmp=node;
				node=node.next;
			}
			if(node==null&&jinwei!=0)tmp.next=new ListNode(jinwei);
		}else if(node1==null&&node2==null&&jinwei!=0){
			tmp.next=new ListNode(jinwei);
		}
		return l1;      
	}
}
