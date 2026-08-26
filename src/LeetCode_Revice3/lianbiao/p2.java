package LeetCode_Revice3.lianbiao;

import LeetCode.ListNode;

/*两数之和*/
public class p2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       ListNode dummy = new ListNode();
       ListNode tial = dummy;
       int carry = 0;
       while (l1 != null || l2 != null){
           int val1 = l1 != null ? l1.val : 0;
           int val2 = l2 != null ? l2.val : 0;
           int sum = val1+ val2 + carry;
           carry = sum / 10;
           int ge = sum % 10;
           tial.next = new ListNode(ge);
           tial = tial.next;
           if(l1 != null) l1= l1.next;
           if(l2 != null) l2= l2.next;

           if(carry > 0) {
               tial.next = new ListNode(carry);
           }
        }
        return dummy.next;
    }
}
