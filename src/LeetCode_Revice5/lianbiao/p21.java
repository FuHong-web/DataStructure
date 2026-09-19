package LeetCode_Revice5.lianbiao;

import LeetCode.ListNode;

import java.nio.IntBuffer;

/*合并两个有序链表*/
public class p21 {
    public ListNode hebing(ListNode l1,ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l1.val){
            hebing(l1.next,l2);
            return l1;
        }else {
            hebing(l1,l2.next);
            return l2;
        }
    }
}
