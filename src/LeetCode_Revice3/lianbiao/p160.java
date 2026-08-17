package LeetCode_Revice3.lianbiao;

import LeetCode.ListNode;

/*相交链表*/
public class p160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA;
        ListNode B = headB;
        while (A!=B) {
            A = (A== null) ? B : A.next;
            B = (B == null) ? B : B.next;
        }
        return  A;
    }
}
