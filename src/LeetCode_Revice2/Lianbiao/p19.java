package LeetCode_Revice2.Lianbiao;

import LeetCode.ListNode;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/22 23:01
 * @desc:删除链表倒数第n个结点
 */
public class p19 {
    public ListNode removeNthFromEnd (ListNode head,int n) {
        ListNode dummy = new ListNode(0,head);
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        cur = head;
        for (int i = 0; i < len - n; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }
}
