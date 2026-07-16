package LeetCode_Revice1.lianbiao;

import LeetCode.ListNode;

/**
 * @author: Yan Tong xue
 * @Created:2026/5/21 23:32
 * @desc:反转链表
 */
public class p206 {
    public ListNode reverseList(ListNode head) {
        ListNode cur=head;
        ListNode pre=null;
        while (cur!=null){
            ListNode temp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=temp;
        }
        return pre;
    }
}
