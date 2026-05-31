package LeetCode;

/**
 * @author: Yan Tong xue
 * @Created:2026/3/29 10:23
 * @desc:力扣第19题：
 */
public class Problem19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy=new ListNode(0,head);
        ListNode left=dummy;
        ListNode right=head;
        //right右走n步
        while (n>0 && right!=null){
            right=right.next;
            n--;
        }
        while (right!=null){
            left=left.next;
            right= right.next;
        }
        left.next=left.next.next;
        return dummy.next;
    }
}
