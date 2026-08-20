package LeetCode;

import jdk.jshell.spi.SPIResolutionException;

import java.util.ServiceLoader;

/**
 * @author: Yan Tong xue
 * @Created:2026/3/23 23:00
 * @desc:力扣第148题排序链表（双指针+归并排序）
 */
public class Problem148 {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast!=null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return mergeTwoList(left,right);
    }
    private ListNode mergeTwoList(ListNode l1,ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val) {
            l1.next = mergeTwoList(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoList(l1,l2.next);
            return l2;
        }
    }
}
