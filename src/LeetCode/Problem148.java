package LeetCode;

/**
 * @author: Yan Tong xue
 * @Created:2026/3/23 23:00
 * @desc:力扣第148题排序链表（双指针+归并排序）
 */
public class Problem148 {
    public ListNode sortList(ListNode head){
        if (head==null||head.next==null){
            return head;
        }
        ListNode fast=head.next;
        ListNode slow=head;
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode temp=slow.next;
        slow.next=null;
        ListNode left=sortList(head);
        ListNode rirgt=sortList(temp);
        ListNode h=new ListNode(0);
        ListNode res=h;
        while (left!=null&&rirgt!=null){
            if (left.val<rirgt.val){
                h.next=left;
                left=left.next;
            }else {
                h.next=rirgt;
                rirgt=rirgt.next;
            }
            h=h.next;
        }
        h.next = left != null ? left : rirgt;
        return res.next;
    }
}
