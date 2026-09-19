package LeetCode_Revice5.lianbiao;

import LeetCode.ListNode;

/*k个一组翻转链表*/
public class p25 {
    public ListNode reverKGroup(ListNode head,int k){
       if(head == null) return head;
       ListNode tail = head;
        for (int i = 0; i < k; i++) {
            if(tail == null) return head;
            tail = tail.next;
        }
        ListNode newHead = reverse(head,tail);
        head.next = reverKGroup(tail,k);
        return newHead;
    }
    public ListNode reverse(ListNode head,ListNode tail) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur!=tail){
            ListNode temp = head.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
