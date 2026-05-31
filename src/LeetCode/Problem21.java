package LeetCode;

/**
 * @author: Yan Tong xue
 * @Created:2025/10/13 22:14
 * @desc:问题21：合并两个有序链表
 */
public class Problem21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
    public ListNode merge(ListNode l1,ListNode l2){
        if (l1==null){
            return l2;
        } else if (l2==null) {
            return l1;
        } else if (l1.val<l2.val) {
            l1.next=merge(l1.next,l2);
            return l1;
        }else {
            l2.next=merge(l1,l2.next);
            return l2;
        }
    }
    
}
