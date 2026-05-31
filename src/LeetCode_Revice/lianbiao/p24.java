package LeetCode_Revice.lianbiao;

import LeetCode.ListNode;
import org.w3c.dom.ls.LSInput;

/**
 * @author: Yan Tong xue
 * @Created:2026/5/25 23:07
 * @desc:两两交换链表中的结点
 */
public class p24 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0,head);
        ListNode pre = dummy;
        ListNode first = head;
        ListNode second = null;
        while (first != null && first.next != null) {
            second = first.next;
            ListNode nextFirst = second.next;
            pre.next = second;
            second.next = first;
            first.next = nextFirst;
            pre = first;
            first = nextFirst;
        }
        return dummy.next;
    }
}
