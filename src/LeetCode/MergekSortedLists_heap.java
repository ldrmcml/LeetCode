package LeetCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergekSortedLists_heap {
	public static final int K=10;
	public ListNode mergeKLists(List<ListNode> lists) {
		if(null==lists||lists.size()==0)
			return null;
		PriorityQueue<ListNode> heap=new PriorityQueue<ListNode>(K,new Comparator<ListNode>(){
			@Override
			public int compare(ListNode o1, ListNode o2) {
				// TODO Auto-generated method stub
				return o1.val-o2.val;
			}
		});
		for(int i=0;i<lists.size();i++){
			ListNode node=lists.get(i);
			if(node!=null){
				heap.offer(node);
			}
		}
		ListNode head=null,pre=head;
		while(!heap.isEmpty()){
			ListNode node=heap.poll();
			if(head==null){
				head=node;
				pre=head;
			}else{
				pre.next=node;
				pre=pre.next;
			}
			if(node.next!=null)heap.offer(node.next);
		}
		return head;
	}
	
	public static void main(String[] args){
		int[] num2={0,2,5};
//		ListNode h1=new ListNode(num1[0]),node1=h1;
//		for(int i=1;i<num1.length;i++){
//			node1.next=new ListNode(num1[i]);
//			node1=node1.next;
//		}

		ListNode h2=new ListNode(num2[0]),node2=h2;
		for(int i=1;i<num2.length;i++){
			node2.next=new ListNode(num2[i]);
			node2=node2.next;
		}

		List<ListNode> lists=new ArrayList<ListNode>();
		//lists.add(h1);
		lists.add(h2);
		
		MergekSortedLists_heap m=new MergekSortedLists_heap();
		ListNode head=m.mergeKLists(lists),node=head;
		while(node!=null){
			System.out.print(node.val+" ");
			node=node.next;
		}
	}
}
