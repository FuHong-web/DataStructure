package LeetCode_Revice1.lianbiao;

import LeetCode.ListNode;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/7 19:55
 * @desc:k个一组翻转链表（分治+递归）
 *
 * 找一段 k 个节点
 * 把这 k 个翻转
 * 递归处理后面的段，再接上
 */
public class p25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        // 边界条件：链表为空或只有一个节点，直接返回
        if (head == null || head.next == null) return head;

        // 1. 先找到当前要翻转的k个节点的尾节点tail（不包含）
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            if (tail == null) return head; // 剩余节点不足k个，直接返回原头
            tail = tail.next;
        }

        // 2. 翻转 [head, tail) 这段链表，得到新头节点newHead
        ListNode newHead = reverserHelper(head, tail);

        // 3. 递归翻转后面的链表，并把当前段的尾节点（原head）连接到下一段的新头
        head.next = reverseKGroup(tail, k);

        // 4. 返回当前段的新头节点
        return newHead;
    }
    public ListNode reverserHelper(ListNode head,ListNode tail) {
        ListNode pre = null;
        ListNode next = null;
        while (head != tail) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
