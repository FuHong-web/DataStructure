package LeetCode_Revice.lianbiao;

import LeetCode.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: Yan Tong xue
 * @Created:2026/5/21 23:53
 * @desc:环形链表
 */
public class p141 {
    public boolean hasCycle1(ListNode head){
        Set<ListNode> seen = new HashSet<>();
        while (head != null) {
            if (! seen.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
}
