package LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: Yan Tong xue
 * @Created:2025/9/15 11:32
 * @desc:力扣第160题
 */
public class Problem160 {
    //方法一：Hash表
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
       Set<ListNode> visited=new HashSet<>();
       ListNode temp=headA;
       while (temp!=null){
           visited.add(temp);
           temp=temp.next;
       }
       temp=headB;
       while (temp!=null){
           if (visited.contains(temp)){
               return temp;
           }
           temp=temp.next;
       }
       return null;
    }
    //方法二：双指针
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode A = headA, B = headB;
            while (A != B) {
                A = A != null ? A.next : headB;
                B = B != null ? B.next : headA;
            }
            return A;
        }
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
