package LeetCode;
/**
 * 对链表排序
 * time:O(nlogn),space:O(c)常数空间
 */
/**
 * 归并满足时间复杂度(O(nlogn)),以前都是在数组上操作
 * 分治法、递归
 * 1、分解为两段
 * 2、分别对两段进行排序
 * 3、将两段有序的序列进行合并
 * @author Administrator
 *
 */
//见SortList->ListNode类
/*class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}*/
public class SortList_My {
	//分段，采用fast-slow方法，一前一后两个指针
	public ListNode getMiddle(ListNode head){
		if(head==null)return null;
		ListNode fast=head,slow=head;
		//肯定是fast先到末尾
		//得保证fast不为空，即fast.next.next不为空
		while(fast.next!=null&&fast.next.next!=null){
			slow=slow.next;
			fast=fast.next.next;//得保证fast.next不为空
		}
		//其实slow.next才为另一半链表的开始，在sortList中作了处理
		return slow;
	}
	//合并两个有序链表
	//新建一个虚拟头结点，作为合并后的链表
	public ListNode mergeList(ListNode head1,ListNode head2){
		ListNode node1=head1,node2=head2;
		ListNode dummyHead=new ListNode(-1);
		ListNode cur=dummyHead;
		while(node1!=null&&node2!=null){
			if(node1.val<=node2.val){
				cur.next=node1;
				node1=node1.next;
			}else{
				cur.next=node2;
				node2=node2.next;
			}
			cur=cur.next;
		}
		//如果node2链表先结束，把node1接到合并链表的当前遍历位置!!!!
		//!!!!!!!!!!!!!!!!
		cur.next=node1!=null?node1:node2;
		return dummyHead.next;
	}
	public ListNode sortList(ListNode head){
		//当链表为空或者只含一个结点时，直接返回
		//这是初始情况，或者说是最原始的情况。就是从一个结点开始归并
		//!!!!!!!!!!!!!!
		if(head==null||head.next==null)return head;
		ListNode middle=getMiddle(head);
		//第二段的开始其实是middle的下一个结点，见getMiddle返回语句的注释
		ListNode another=middle.next;
		//必须赋为null作为第一段链表的结束标志，在mergeList方法中可以看到，将null作为链尾标志
		//!!!!!!!!!!!!!!!!!!!!
		middle.next=null;
		return mergeList(sortList(head),sortList(another));
	}
	public static void main(String[] args){
    	int[] arr=new int[]{-1,2,-4,9,3,11,13,0};
    	ListNode head=new ListNode(arr[0]),node=head;;
    	for(int i=1;i<arr.length;i++){
    		node.next=new ListNode(arr[i]);
    		node=node.next;
    	}
    	node=new SortList_My().sortList(head);
    	while(node!=null){
    		System.out.print(node.val+" ");
    		node=node.next;
    	}
    }
}
