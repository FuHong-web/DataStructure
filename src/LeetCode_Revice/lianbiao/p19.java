package LeetCode_Revice.lianbiao;

import LeetCode.ListNode;

/**
 * @author: Yan Tong xue
 * @Created:2026/5/25 22:45
 * @desc:删除链表倒数第n个结点
 */
public class p19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0,head);
        ListNode left = dummy;
        ListNode right = head;
        while (n > 0 && right != null) {
            right = right.next;
            n--;
        }
        while (right != null) {
            right=right.next;
            left = left.next;
        }
        left.next = left.next.next;
        return dummy.next;
    }
}
