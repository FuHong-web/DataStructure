package LeetCode_Revice1.lianbiao;

import LeetCode.ListNode;

/**
 * @author: Yan Tong xue
 * @Created:2026/5/25 23:25
 * @desc:排序链表（归并排序）
 */
public class p148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(second);

        // ========= 合并部分开始 =========
        ListNode dummyHead = new ListNode(0); // 保存最终头
        ListNode curr = dummyHead;           // 用来移动拼接

        while (left != null && right != null) {
            if (left.val < right.val) {
                curr.next = left;
                left = left.next;
            } else {
                curr.next = right;
                right = right.next;
            }
            curr = curr.next; // ✅ 移动当前指针
        }

        curr.next = left != null ? left : right;
        return dummyHead.next; // ✅ 返回真正头
    }

}
