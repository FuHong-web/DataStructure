package LeetCode_Revice4.lianbiao;

import LeetCode.ListNode;

import java.util.ArrayList;
import java.util.List;

/*回文链表*/
public class p234 {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur!=null){
            list.add(cur.val);
            cur = cur.next;
        }
        int left = 0;
        int right = list.size()-1;
        while (left < right){
            while (!list.get(left).equals(list.get(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
