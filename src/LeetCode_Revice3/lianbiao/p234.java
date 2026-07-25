package LeetCode_Revice3.lianbiao;

import LeetCode.ListNode;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/*回文链表*/
public class p234 {
    public boolean isPalindrome(ListNode head){
        List<Integer> vals = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            vals.add(cur.val);
            cur = cur.next;
        }
        int left = 0;
        int rifght = vals.size() - 1;
        while (left < rifght) {
            if (! vals.get(left).equals(vals.get(rifght))){
                return false;
            }
            left++;
            rifght--;
        }
        return true;
    }
}
