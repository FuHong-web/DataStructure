package LeetCode_Revice5.lianbiao;

import LeetCode.ListNode;
import org.w3c.dom.ls.LSInput;

/*删除链表倒数第n个几点*/
public class p19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0,head);
        ListNode cur = dummy;
        ListNode temp = cur;
        int len = 0;
        while (cur != null){
            len++;
            cur = cur.next;
        }
        for(int i = 0;i< len-n;i++){
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }


}
