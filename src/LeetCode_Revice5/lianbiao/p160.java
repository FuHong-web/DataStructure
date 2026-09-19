package LeetCode_Revice5.lianbiao;

import LeetCode.ListNode;

/*相交链表*/
public class p160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        ListNode a = headA;
        ListNode b = headB;
        while (a !=  b){
            a = (a == null) ? b : a.next;
            b = (b == null) ? a : b.next;
        }
        return a;
    }
}
