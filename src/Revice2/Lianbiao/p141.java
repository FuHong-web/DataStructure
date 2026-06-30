package Revice2.Lianbiao;

import LeetCode.ListNode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/24 9:50
 * @desc:环形链表
 */
public class p141 {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> seen = new HashSet<>();
        while (head != null) {
            if (!seen.add(head)){
                return true;
            }
            head = head.next;
        }
        return false;
    }
}
