package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Yan Tong xue
 * @Created:2026/3/13 17:47
 * @desc:回文链表
 * 将链表的值复制到数组列表中，再使用双指针法判断
 */
public class Problem234 {
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
        return false;
    }

}
