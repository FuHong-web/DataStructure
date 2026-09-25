package LeetCode_Revice3.zichuan;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/*滑动窗口的最大值*/
public class p239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
       int index =0;
        int[] res = new int[n-k+1];
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!queue.isEmpty() && nums[i] > nums[queue.peekLast()]){
                queue.pollLast();
            }
            queue.add(i);
            while (queue.peekFirst() <= i-k){
                queue.pollFirst();
            }
            if(i >= k-1){
                res[index++] = nums[queue.peekLast()];
            }
        }
        return res;
    }
}
