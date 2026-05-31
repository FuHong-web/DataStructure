package LeetCode;

/**
 * @author: Yan Tong xue
 * @Created:2026/4/21 22:17
 * @desc:环形链表II（快慢指针）
 */
public class Problem142 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        // 1. 快慢指针判断是否有环，并找到相遇点
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        // 如果没有环，直接返回 null
        if (fast == null || fast.next == null) {
            return null;
        }
        // 2. 快指针回到头节点，同速前进，再次相遇即为环的入口
        fast = head;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
