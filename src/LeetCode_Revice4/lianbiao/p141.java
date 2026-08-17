package LeetCode_Revice4.lianbiao;

import LeetCode.ListNode;

import java.util.HashSet;
import java.util.Set;

/*环形链表*/
public class p141 {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode cur = head;
        while (cur!=null){
            if(set.contains(cur)) {
                return true;
            }
            set.add(cur);
            cur = cur.next;
        }
        return false;
    }
}
