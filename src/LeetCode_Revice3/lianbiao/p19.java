package LeetCode_Revice3.lianbiao;

import LeetCode.ListNode;

/*删除链表倒数第n个结点*/
public class p19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0,head);
        ListNode cur = dummy;
        ListNode temp = head;
        int len = 0;
        while (temp != null) {
            len+=1;
            temp= temp.next;
        }
        for (int i = 0;i< len-n;i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }
}
