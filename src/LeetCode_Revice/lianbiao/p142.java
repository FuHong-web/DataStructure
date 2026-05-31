package LeetCode_Revice.lianbiao;

import LeetCode.ListNode;

/**
 * @author: Yan Tong xue
 * @Created:2026/5/24 22:44
 * @desc:环形链表ii（快慢指针）
 */
public class p142 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow ) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        fast = head;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
