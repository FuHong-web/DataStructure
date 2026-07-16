package LeetCode_Revice1.lianbiao;

/**
 * @author: Yan Tong xue
 * @Created:2026/5/24 23:14
 * @desc:两数相加
 */
public class p2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        int carry = 0;

        // 循环：只要有一个链表没走完就继续
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;

            // 创建新节点
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }

            // 更新进位
            carry = sum / 10;

            // 指针后移
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;

        }  // -------------- while 循环结束 ----------------

        // 【重要】循环结束后，如果还有进位，要追加最后一个节点
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }

        // 【正确位置】return 必须放在循环外面！
        return head;
    }
}
