package LeetCode_Revice4.lianbiao;

import LeetCode.ListNode;

import java.util.HashSet;
import java.util.Set;

/*相交链表*/
public class p160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        while (a!=b) {
            a = (a== null) ? b : a.next;
            b = (a== null) ? a : b.next;
        }
        return a;
    }
}
