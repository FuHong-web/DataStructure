package LeetCode_Revice3.lianbiao;

import LeetCode.ListNode;

import java.util.HashSet;
import java.util.Set;

/*环形链表II*/
public class p142 {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> nodes = new HashSet<>();
        ListNode cur = head;
        while (cur != null) {
            if (nodes.contains(cur)) {
                return cur;
            }
            nodes.add(cur);
            cur = cur.next;
        }
        return null;
    }
}
