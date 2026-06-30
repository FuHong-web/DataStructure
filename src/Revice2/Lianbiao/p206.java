package Revice2.Lianbiao;

import LeetCode.ListNode;
import jdk.dynalink.linker.LinkerServices;
import org.w3c.dom.ls.LSInput;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/24 10:08
 * @desc:反转链表
 */
public class p206 {
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
