package LeetCode;

/**
 * @author: Yan Tong xue
 * @Created:2025/10/13 22:14
 * @desc:问题21：合并两个有序链表
 */
public class Problem21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
       if (list1 == null) return list2;
       if (list2 == null) return list1;
       if (list1.val <= list2.val) {
           list1.next = mergeTwoLists(list1.next,list2);
           return list1;
       }else {
           list2.next = mergeTwoLists(list1,list2.next);
           return list2;
       }
}}
