package LeetCode_Revice1.lianbiao;

import LeetCode.ListNode;

/**
 * @author: Yan Tong xue
 * @Created:2026/5/21 23:14
 * @desc:
 */
public class p160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA, B = headB;
        while (A != B) {
            A = A != null ? A.next : headB;
            B = B != null ? B.next : headA;
        }
        return A;
    }
}
