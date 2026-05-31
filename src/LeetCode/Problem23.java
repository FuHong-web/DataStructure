package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Yan Tong xue
 * @Created:2026/5/5 21:06
 * @desc:合并k个有序链表
 */
public class Problem23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        List<ListNode> list = new ArrayList<>();
        for (ListNode node : lists) {
            list.add(node);
        }

        while (list.size() > 1) {
            List<ListNode> tempList = new ArrayList<>();
            // 两两一组合并
            for (int i = 0; i < list.size(); i += 2) {
                ListNode l1 = list.get(i);
                ListNode l2 = (i + 1 < list.size()) ? list.get(i + 1) : null;
                tempList.add(mergeTwo(l1, l2));
            }
            list = tempList;
        }

        return list.get(0);
    }

    // 递归合并两个有序链表
    private ListNode mergeTwo(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val < l2.val) {
            l1.next = mergeTwo(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwo(l1, l2.next);
            return l2;
        }
    }

}
