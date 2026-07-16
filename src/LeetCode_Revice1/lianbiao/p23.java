package LeetCode_Revice1.lianbiao;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/14 15:53
 * @desc:合并k个升序链表
 */
public class p23 {
    public ListNode mergeTwoKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        List<ListNode> list = new ArrayList<>();
        for (ListNode node : lists) {
            list.add(node);
        }
        while (list.size() > 1) {
            List<ListNode> tempList = new ArrayList<>();
            for (int i = 0; i < list.size(); i += 2) {
                ListNode l1 = list.get(i);
                ListNode l2 = null;
                if (i + 1 < list.size()) {
                    l2 = list.get(i + 1);
                }
                tempList.add(mergeTwoLists(l1, l2));
            }
            list = tempList;
        }
        return list.get(0);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        // ✅ 修正后的剩余节点拼接逻辑
        if (list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }
        return dummy.next;
    }

}
