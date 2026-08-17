package LeetCode_Revice4.lianbiao;

import LeetCode.ListNode;

import java.util.HashSet;
import java.util.Set;

/*环形链表ii*/
public class p142 {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode cur = head;
        while (cur!=null) {
            if(set.contains(cur)){
                return cur;
            }
            set.add(cur);
            cur = cur.next;
        }
        return null;
    }
}
