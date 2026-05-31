package LeetCode_Revice.lianbiao;

import LeetCode.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Yan Tong xue
 * @Created:2026/5/21 23:46
 * @desc:
 */
public class p234 {
    public boolean isPalindrome(ListNode head){
        List<Integer> vals=new ArrayList<>();
        ListNode curnode=head;
        while (curnode!=null){
            vals.add(curnode.val);
            curnode=curnode.next;
        }
        int front=0;
        int rear=vals.size()-1;
        while (front<rear){
            if (!vals.get(front).equals(vals.get(rear))){
                return false;
            }
            front++;
            rear--;
        }
        return true;  // 这里必须是 true！！！
    }

}
