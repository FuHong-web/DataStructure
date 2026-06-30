package Revice2.huadongchuangkou;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/29 22:07
 * @desc:滑动窗口的最大值
 */
public class p239 {
    public static int[] minSubArrayLen(int k, int[] nums) {
        int  n = nums.length;
        int[] res = new int[n - k + 1 ];
        Deque<Integer> deque= new LinkedList<>();
        int index = 0;
        for (int right = 0; right< n;right++) {
            while (!deque.isEmpty() && nums[right] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(right);
            int left = right - k +1;
            while (deque.peekFirst() < left) {
                deque.peekFirst();
            }
            if (right >= k -1) {
                res[index++] = nums[deque.peekFirst()];
            }
        }
        return res;
    }
}
