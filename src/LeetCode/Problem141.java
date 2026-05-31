package LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: Yan Tong xue
 * @Created:2025/9/15 10:41
 * @desc:力扣第141题：环形链表
 */
public class Problem141 {
    public static void main(String[] args) {

    }
    //方法一：Hash表
    public boolean hasCycle1(ListNode head) {
        Set<ListNode> seen=new HashSet<ListNode>();
        while (head!=null){
            if (!seen.add(head)){
                return true;
            }
            head=head.next;
        }
        return false;
    }
    //方法二：快慢指针
    public boolean hasCycle2(ListNode head){
        if (head == null || head.next == null) {
            return false;
                }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
                }
                return true;
            }
        }



