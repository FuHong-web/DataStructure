package LeetCode_Revice2.Lianbiao;

import LeetCode.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Yan Tong xue
 * @Created:2026/7/17 0:19
 * @desc:回文链表
 */
public class p234 {
    public boolean isPalindrome(ListNode head) {
        List<Integer> array = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            array.add(cur.val);
            cur = cur.next;
        }
        int left = 0;
        int right = array.size() - 1;
        while (left < right) {
            if (! array.get(left).equals(array.get(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
