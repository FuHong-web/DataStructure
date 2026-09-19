package LeetCode_Revice5.lianbiao;

import LeetCode.ListNode;

import java.time.temporal.JulianFields;
import java.util.ArrayList;
import java.util.List;

/*回文链表*/
public class p230 {
    public boolean huiwenListNode(ListNode head){
        List<Integer> listNodes =new  ArrayList<>();
        ListNode cur = head;
        while (cur!= null){
            listNodes.add(cur.val);
            cur = cur.next;
        }
        int left = 0;
        int right = listNodes.size()-1;
        while (left <right){
            if(!listNodes.get(left).equals(listNodes.get(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
