package LeetCode;

/**
 * @author: Yan Tong xue
 * @Created:2026/1/21 21:44
 * @desc:力扣第206题
 */
public class Problem206 {
    public ListNode reverseList(ListNode head) {
        ListNode cur=head;
        ListNode pre=null;
        while (cur!=null){
            ListNode temp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=temp;
        }
        return pre;
    }
}
