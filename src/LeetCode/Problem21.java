package LeetCode;

/**
 * @author: Yan Tong xue
 * @Created:2025/10/13 22:14
 * @desc:问题21：合并两个有序链表
 */
public class Problem21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 虚拟头节点，简化边界处理
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        // 两个链表都不为空时，取较小值拼接
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next; // 移动尾指针
        }

        // 拼接剩余的节点（其中一条链表已经遍历完）
        if (list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }

        // 返回合并后的链表（跳过虚拟头节点）
        return dummy.next;
    }


}
