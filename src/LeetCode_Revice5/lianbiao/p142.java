package LeetCode_Revice5.lianbiao;

import LeetCode.ListNode;

import java.util.HashSet;
import java.util.Set;

/*环形链表II*/
public class p142 {
    public ListNode haunxing(ListNode head){
        if(head== null) return null;
        ListNode cur = head;
        Set<ListNode> set = new HashSet<>();
        while (cur != null){
            if(set.contains(cur)){
                return cur;
            }
            set.add(cur);
            cur = cur.next;
        }
        return null;
    }
}
