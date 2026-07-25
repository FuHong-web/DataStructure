package LeetCode_Revice3.lianbiao;

import LeetCode.ListNode;

/*两两交换链表的结点*/
public class p24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode second = head.next;
        head.next = swapPairs(second.next);
        second.next = head;
        return second;
    }
}
