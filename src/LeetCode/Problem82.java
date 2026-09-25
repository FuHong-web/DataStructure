package LeetCode;
/*删除排序链表的重复元素II*/
public class Problem82 {
    public ListNode deleteDuplicates(ListNode head){
        ListNode dummy = new ListNode(0,head);
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null){
            if(cur.next.val == cur.next.next.val){
                int value = cur.next.val;
                while (cur.next != null && cur.next.val == value){
                    cur.next = cur.next.next;
                }
            }else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
