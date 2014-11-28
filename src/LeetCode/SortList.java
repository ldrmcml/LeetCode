package LeetCode;

import java.util.Arrays;

/*class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}*/
/**
 * 空间复杂度为O(n)，该方法不符合常数空间复杂度的要求!!!!
 * 拷贝到数组，采用Arrays.sort()方法排序，再拷贝回来
 * 类库采用快排？三分归并？
 * @author Administrator
 *
 */
public class SortList {
    public ListNode sortList(ListNode head) {
    	int len=0;
    	ListNode node=head;
    	while(node!=null){
    		len++;
    		node=node.next;
    	}
        int[] arr=new int[len];
        int i=0;
        node=head;
        while(node!=null){
        	arr[i++]=node.val;
        	node=node.next;
        }
        Arrays.sort(arr);
        node=head;
        i=0;
        while(node!=null){
        	node.val=arr[i++];
        	node=node.next;
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
    	new SortList().sortList(head);
    	node=head;
    	while(node!=null){
    		System.out.print(node.val+" ");
    		node=node.next;
    	}
    }
}