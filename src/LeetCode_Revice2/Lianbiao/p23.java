package LeetCode_Revice2.Lianbiao;

import LeetCode.ListNode;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/23 23:41
 * @desc:合并k个升序链表
 */
public class p23 {
    public ListNode mergeKLists (ListNode[] listNodes) {
        ListNode res = null;
        for (ListNode listNode : listNodes) {
            res = mergeTwoLists(res,listNode);
        }
        return res;
    }
    public ListNode mergeTwoLists(ListNode l1,ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            }else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
       tail.next = l1 == null ? l2 : l1;
        return dummy.next;
    }

}
