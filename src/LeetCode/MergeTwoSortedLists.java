package LeetCode;

public class MergeTwoSortedLists {
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode node1=l1,node2=l2,head=null,node=null;
		if(null==l1)return l2;
		else if(null==l2)return l1;
		if(node1.val<node2.val)head=l1;
		else head=l2;
		while(node1!=null&&node2!=null){
			if(node1.val<node2.val){
				while(node1!=null&&node1.val<node2.val){
					node=node1;
					node1=node1.next;
				}
				node.next=node2;
			}else{
				while(node2!=null&&node2.val<=node1.val){
					node=node2;
					node2=node2.next;
				}
				node.next=node1;
			}
		}
		return head;
	}
	public static void main(String[] args){
		int[] num1={5},num2={1,2,4};
		ListNode h1=new ListNode(num1[0]),node1=h1;
		for(int i=1;i<num1.length;i++){
			node1.next=new ListNode(num1[i]);
			node1=node1.next;
		}

		ListNode h2=new ListNode(num2[0]),node2=h2;
		for(int i=1;i<num2.length;i++){
			node2.next=new ListNode(num2[i]);
			node2=node2.next;
		}

		ListNode head=mergeTwoLists(h1, h2),node=head;
		while(node!=null){
			System.out.print(node.val+" ");
			node=node.next;
		}
	}
}
