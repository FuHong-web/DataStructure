package LeetCode_Revice.zichuan;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/8 22:12
 * @desc:滑动窗口的最大值 （双端队列）:
 *用一个队列，只保留 “有可能成为最大值” 的数字下标，保证队头永远是最大值
 */
public class p239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            /*我现在来了一个新数
            队列里所有比我小的数，永远不可能成为最大值了
            直接删掉！*/
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            //. 把我加进队列
            deque.offerLast(i);
            //队头超出窗口了 → 扔掉
            if (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            // 窗口成型 → 取队头就是最大值
            if (i >= k - 1) {
                res[index++] = nums[deque.peekFirst()];
            }
        }
        return res;
    }
}
