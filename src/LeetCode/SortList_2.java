package LeetCode;
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class SortList_2 {
     //use the fast and slow pointer to get the middle of a ListNode
     ListNode getMiddleOfList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null&&fast.next.next!=null) {
        	slow = slow.next;
        	fast = fast.next.next;
        }
        return slow;
    }
    
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null) {
            return head;
        }
    	ListNode middle = getMiddleOfList(head);
    	ListNode next   = middle.next;
    	    middle.next = null;
    	return mergeList(sortList(head), sortList(next));
    }
    
    //merge the two sorted list
    ListNode mergeList(ListNode a, ListNode b) {
    	ListNode dummyHead = new ListNode(-1);
    	ListNode curr = dummyHead;
    	while(a!=null&&b!=null) {
    		if(a.val<=b.val) {
    			curr.next=a;a=a.next;
    		} else {
    			curr.next=b;b=b.next;
    		}
    		curr  = curr.next;
    	}
    	curr.next = a!=null?a:b;
    	return dummyHead.next;
    }
    
    public static void main(String[] args){
    	int[] arr=new int[]{-1,2,-4,9,3,11,13,0};
    	ListNode head=new ListNode(arr[0]),node=head;;
    	for(int i=1;i<arr.length;i++){
    		node.next=new ListNode(arr[i]);
    		node=node.next;
    	}   	
    	node=new SortList_2().sortList(head);
    	while(node!=null){
    		System.out.print(node.val+" ");
    		node=node.next;
    	}
    }
}