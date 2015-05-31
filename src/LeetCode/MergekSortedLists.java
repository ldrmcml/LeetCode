package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class MergekSortedLists {
	public ListNode merge2(ListNode node1,ListNode node2){
		// merge两条有序链表
		// 特殊情况
		if(node1==null)return node2;
		if(node2==null)return node1;
		
		// 将较小ndoe记录为新表头
		ListNode head=null,node=null;
		if(node1.val<node2.val)head=node1;
		else head=node2;
		
		while(node1!=null&&node2!=null){
			if(node1.val<node2.val){
				// 直到node1》node2
				while(node1!=null&&node1.val<node2.val){
					// node记录前驱节点
					node=node1;
					node1=node1.next;
				}
				node.next=node2;
			}else{
				// 不要错过==的情况
				while(node2!=null&&node2.val<=node1.val){
					node=node2;
					node2=node2.next;
				}
				node.next=node1;
			}
		}
		
		return head;
	}
	public ListNode merge(List<ListNode> lists,int lo,int hi){
		if(lo==hi)return lists.get(lo);
		int middle=(lo+hi)/2;
		ListNode left=merge(lists,lo,middle);
		ListNode right=merge(lists,middle+1,hi);
		return merge2(left,right);
	}
	public ListNode mergeKLists(List<ListNode> lists) {
		// 特殊情况
		if(null==lists||lists.size()==0)return null;
		// 分治法，两两merge
		return merge(lists,0,lists.size()-1);
	}
	
	public static void main(String[] args){
		int[] num1={1,2,2},num2={1,1,2};
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

		List<ListNode> lists=new ArrayList<ListNode>();
		lists.add(h1);
		lists.add(h2);
		
		MergekSortedLists m=new MergekSortedLists();
		ListNode head=m.mergeKLists(lists),node=head;
		while(node!=null){
			System.out.print(node.val+" ");
			node=node.next;
		}
	}
}
