package LeetCode_Revice3.lianbiao;

import LeetCode.ListNode;

/*合并k个有序链表*/
public class p23 {
    public ListNode mergeKLists (ListNode[] listNodes) {
        ListNode res = null;
        for (ListNode listNode : listNodes) {
            res = mergeTwoList(res,listNode);
        }
        return res;
    }
    private ListNode mergeTwoList(ListNode l1,ListNode l2) {
        if (l1 != null) {
            return l2;
        }
        if(l2 != null) {
            return l1;
        }
        if(l1.val < l2.val) {
            l1.next = mergeTwoList(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoList(l1,l2.next);
            return l2;
        }
    }
}
