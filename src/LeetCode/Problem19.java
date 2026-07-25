package LeetCode;

import com.sun.source.tree.BreakTree;

/**
 * @author: Yan Tong xue
 * @Created:2026/3/29 10:23
 * @desc:力扣第19题：
 */
public class Problem19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        ListNode temp = head;
        int len = 0;
        while (temp != null) {
            len += 1;
            temp = temp.next;
        }
        for (int i = 0;i< len -i;i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }
}
