package LeetCode_Revice2.zichuan;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: Yan Tong xue
 * @Created:2026/7/5 13:43
 * @desc：滑动窗口的最大值
 */
public class p239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] res = new int[len - k + 1];
        // 双端队列存数组下标，维持单调递减
        Deque<Integer> deque = new LinkedList<>();
        int index = 0;
        for (int i = 0 ; i < len; i++) {
            // 1. 维护单调递减：队尾比当前数小，全部弹出
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            // 存入当前下标，不是数值
            deque.offerLast(i);

            // 2. 清理已经滑出窗口左边界的过期下标
            // 窗口合法左边界：i - k + 1
            if (deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // 3. 窗口成型，开始记录最大值
            if (i >= k - 1) {
                // 最大值永远在队头，只读取不弹出
                res[index++] = nums[deque.peekFirst()];
            }
        }
        return res;
    }
}
