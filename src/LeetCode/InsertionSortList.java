package LeetCode;
//见SortList->ListNode类
/*class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}*/
public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
		//这种情况不要漏掉，否则第三句head.val会产生空指针错误!!!!!!!
        if(head==null)return null;
    	//一般情况记录两个指针
    	ListNode pre=null,node=null,node1=null;
    	//将首结点放进新链表
    	ListNode newHead=new ListNode(head.val);
    	//从第二个结点开始
    	node=head.next;
    	while(node!=null){
    		//node与新链表进行比较,由小到大排列
    		node1=newHead;
    		//对于插入头结点需要特殊处理
    		if(node.val<node1.val){
    			newHead=new ListNode(node.val);
    			newHead.next=node1;
    		}else{
    			//判断条件格外注意，node1!=null先判断，再判断后面的条件
    			//要注意等于的情况不要漏掉！！！！！！！！！
    			while(node1!=null&&node.val>=node1.val){
    				pre=node1;
    				node1=node1.next;
    			}
    			pre.next=new ListNode(node.val);
    			pre.next.next=node1;
    		}
    		node=node.next;
    	}
    	return newHead;
    }
    public static void main(String[] args){
    	int[] arr=new int[]{-1,2,-4,9,3,11,13,0};
    	ListNode head=new ListNode(arr[0]),node=head;;
    	for(int i=1;i<arr.length;i++){
    		node.next=new ListNode(arr[i]);
    		node=node.next;
    	}
    	node=new InsertionSortList().insertionSortList(head);
    	while(node!=null){
    		System.out.print(node.val+" ");
    		node=node.next;
    	}
    }
}
