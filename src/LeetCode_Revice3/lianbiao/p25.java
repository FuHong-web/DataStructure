package LeetCode_Revice3.lianbiao;

import LeetCode.ListNode;

import java.awt.desktop.AppReopenedListener;

/*k个翻转链表*/
public class p25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return head;
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            if(tail == null) return head;
            tail = tail.next;
        }
        ListNode newHead = reverseListNode(head,tail);
        head.next = reverseKGroup(tail,k);
        return newHead;

    }
    private ListNode reverseListNode(ListNode head, ListNode tail) {
       ListNode pre = null;
       ListNode cur = head;
       while (cur != tail){
           ListNode temp = cur.next;
           cur.next = pre;
           pre = cur;
           cur = temp;
       }
       return pre;
    }
}
