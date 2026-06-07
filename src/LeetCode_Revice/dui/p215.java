package LeetCode_Revice.dui;

import java.util.PriorityQueue;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/2 23:03
 * @desc:数组中第k大的元素(小顶堆)
 */
public class p215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num : nums) {
            heap.offer(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }
            return heap.peek();
    }
}
