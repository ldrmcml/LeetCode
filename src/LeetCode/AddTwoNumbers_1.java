package LeetCode;

public class AddTwoNumbers_1 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        //先设立一个伪头节点
        ListNode rs = new ListNode(0);
        ListNode cur = rs;
        while(l1 != null || l2 != null) {
            int i = 0;
            int j = 0;
            if(l1 != null) {
                i = l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                j = l2.val;
                l2 = l2.next;
            }
            int sum = i + j + carry;
            cur.next = new ListNode(sum%10);
            cur = cur.next;
            carry = sum/10;
        }
        if(carry > 0) cur.next = new ListNode(carry);
               return rs.next;
        
    }
}
