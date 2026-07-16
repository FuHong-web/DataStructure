package LeetCode_Revice2.Lianbiao;

import LeetCode.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/24 9:41
 * @desc:排序链表
 */
public class p148 {
    public ListNode sortLsit(ListNode head) {
        List<Integer> vals = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            vals.add(cur.val);
            cur = cur.next;
        }
        if (vals.isEmpty()) return null;
        Collections.sort(vals);
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        for (Integer val : vals) {
            tail.next = new ListNode(val);
            tail = tail.next;
        }
        return dummy.next;
    }
}
