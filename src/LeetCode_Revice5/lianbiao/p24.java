package LeetCode_Revice5.lianbiao;

import LeetCode.ListNode;

/*两两交换链表中的节点*/
public class p24 {
    public ListNode swapRwo(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode second = head.next;
        head.next = swapRwo(second.next);
        second.next = head;
        return second;
    }
}
