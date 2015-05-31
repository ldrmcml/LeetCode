package LeetCode;

import java.util.List;

public class MergekSortedLists_dummy {
	public ListNode helper(List<ListNode> lists,int lo,int hi){
		if(lo==hi)return lists.get(lo);
		int middle=(lo+hi)/2;
		ListNode left=helper(lists,lo,middle);
		ListNode right=helper(lists,middle+1,hi);
		return merge(left,right);
	}
	public ListNode mergeKLists(List<ListNode> lists) {
		// 特殊情况
		if(null==lists||lists.size()==0)return null;
		// 分治法，两两merge
		return helper(lists,0,lists.size()-1);
	}
	private ListNode merge(ListNode l1, ListNode l2)
	{ 
	    ListNode dummy = new ListNode(0);
	    dummy.next = l1;
	    ListNode cur = dummy;
	    while(l1!=null && l2!=null)
	    {
	        if(l1.val<l2.val)
	        {
	            l1 = l1.next;
	        }
	        else
	        {
	            ListNode next = l2.next;
	            cur.next = l2;
	            l2.next = l1;
	            l2 = next;
	        }
	        cur = cur.next;
	    }
	    if(l2!=null)
	        cur.next = l2;
	    return dummy.next;
	}
}
