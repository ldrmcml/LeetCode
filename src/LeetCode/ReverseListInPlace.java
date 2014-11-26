package LeetCode;

public class ReverseListInPlace {
	//单向链表就地反转(不修改节点内容value)
	//注意node为指向某一具体对象的引用，可以以有多个引用指向同一对象，只要一个引用修改，则对象即被修改
	//必须将head作为返回值返回，反转才生效
	public ListNode reverse(ListNode head){
		ListNode node=head;
		//先将head的直接后驱保存
		node=head.next;
		//将head指向null
		head.next=null;
		while(node!=null){
			ListNode tmp=node.next;
			node.next=head;
			head=node;
			node=tmp;
		}
		return head;
	}
	public static void main(String[] args){
		int arr[]={1,2,3};
		ListNode head=new ListNode(arr[0]),node=head;
		for(int i=1;i<arr.length;i++){
			node.next=new ListNode(arr[i]);
			node=node.next;
		}
		node=head;
		while(node!=null){
			System.out.println(node.val);
			node=node.next;
		}
	}
}
