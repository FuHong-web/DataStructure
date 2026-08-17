package LeetCode_Revice4.zichuan;

import java.util.ArrayDeque;
import java.util.Deque;

/*滑动窗口的最大值*/
public class p239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        Deque<Integer> deque = new ArrayDeque<>();
        int index = 0;
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && nums[i] > deque.peekLast()){
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst() <= i -k){
                deque.pollFirst();
            }
             if(i >= k-1){
                 ans[index++] = nums[deque.peekFirst()];
             }
        }
        return ans;
    }
}
