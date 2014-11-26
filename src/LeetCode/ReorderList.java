package LeetCode;

import java.util.Stack;

//ListNode类在SortList.java中已经有定义
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
public class ReorderList {
    public void reorderList(ListNode head) {
    	//如果链表为空或者只有一个结点或者两个结点
    	if(head==null||head.next==null||head.next.next==null)return;
        Stack<ListNode> stack=new Stack<ListNode>();
        ListNode fast=head,slow=head,node;
        //fast-slow方法找到链表中间位置
        while(fast!=null&&fast.next!=null){
        	slow=slow.next;
        	fast=fast.next.next;
        }
        node=slow;
        //继续向前走一步,node所保存结点无需入栈
        slow=slow.next;
        //必须将新链表最末元素后继置为空
        node.next=null;
        //将后半段链表入栈
        while(slow!=null){
        	stack.push(slow);
        	slow=slow.next;
        }
        node=head;
        //谁先到达null？？
        while(!stack.empty()&&node!=null){
        	ListNode tmp=stack.pop();
        	//nodeTmp将node直接后继结点保存起来
        	ListNode nodeTmp=node.next;
        	tmp.next=node.next;
        	node.next=tmp;
        	node=nodeTmp;
        }
    }
}