package LeetCode;

/**
 * @author: Yan Tong xue
 * @Created:2026/3/18 9:08
 * @desc:力扣第2题（模拟）
 */
public class Problem2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       ListNode dummy = new ListNode();
       ListNode tail = dummy;
       int jin = 0;
       while (l1 != null || l2 != null) {
           int val1 = l1 == null ? 0 : l1.val;
           int val2 = l2 == null ? 0 : l2.val;
           int sum = val1 + val2 + jin;
           jin = sum / 10;
           int ge = sum % 10;
           tail.next = new ListNode(ge);// 把新节点挂到 tail 的后面
           tail = tail.next;// tail指针向后移动一步
           if (l1 != null) l1 = l1.next;
           if (l2 != null) l2= l2.next;
       }
       if (jin > 0) tail.next = new ListNode(jin);
       return dummy.next;
}}

