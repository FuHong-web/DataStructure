package Revice2.Lianbiao;

import LeetCode.ListNode;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/24 10:20
 * @desc:K个一组翻转链表
 */
public class p25 {
    public ListNode reverseKGroup (ListNode head,int k) {
        if (head == null || head.next == null) return head;
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            if (tail == null) return head;
            tail = tail.next;
        }
        ListNode newHead = reverse(head,tail);
        newHead.next  = reverseKGroup(tail,k);
        return newHead;


    }
    public ListNode reverse(ListNode head,ListNode tail) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != tail) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
