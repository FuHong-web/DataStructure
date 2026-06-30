package Revice2.Lianbiao;

import LeetCode.ListNode;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/23 23:28
 * @desc:两两交换链表的两个结点
 */
public class p24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode sec = head.next;
        head.next = swapPairs(sec.next);
        sec.next = head;
        return sec;
    }
}
