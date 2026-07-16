package LeetCode_Revice2.Lianbiao;

import LeetCode.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/24 9:56
 * @desc:环形链表ii
 */
public class p142 {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> seen = new HashSet<>();
        ListNode cur = head;
        while (cur != null) {
            if (seen.contains(cur)) {
                return cur;
            }
            seen.add(cur);
            cur = cur.next;
        }
        return null;
    }
}
