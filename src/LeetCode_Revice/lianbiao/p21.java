package LeetCode_Revice.lianbiao;

import LeetCode.ListNode;

/**
 * @author: Yan Tong xue
 * @Created:2026/5/24 23:02
 * @desc:合并两个有序链表
 */
public class p21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {       // l1空，返回l2
            return l2;
        }else if (l2 == null) { // l2空，返回l1
            return l1;
        }else if (l1.val < l2.val) { // l1更小
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else { // 剩下的所有情况：l2更小 或 相等
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
}
