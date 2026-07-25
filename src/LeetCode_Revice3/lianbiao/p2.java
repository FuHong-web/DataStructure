package LeetCode_Revice3.lianbiao;

import LeetCode.ListNode;

/*两数之和*/
public class p2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        int jin = 0;
        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = val1+val2+jin;
            jin = jin /10;
            int ge=sum % 10;
            tail.next = new ListNode(ge);
            tail = tail.next;
            if (l1!=null) l1 = l1.next;
            if (l2!= null) l2 = l2.next;
        }
        if (jin > 0) tail.next = new ListNode(jin);
        return dummy.next;
    }
}
