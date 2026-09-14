package LeetCode_Revice5.zichuan;

import java.util.ArrayDeque;
import java.util.Deque;

/**/
public class p239 {
    public int[] maxLidingWindow(int[] nums,int k){
        int n = nums.length;
        int[] res = new int[n-k+1];
        Deque<Integer> deque = new ArrayDeque<>();
        int index = 0;
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst() <= i-k) {
                deque.pollFirst();
            }
            if(i >= k-1){//第一个窗口成型（0到k-1），之后窗口都成型
                res[index++] = nums[deque.peekFirst()];
            }
        }
        return res;
    }
}
