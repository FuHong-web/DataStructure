package LeetCode;

import java.util.PriorityQueue;

/**
 * @author: Yan Tong xue
 * @Created:2026/5/5 21:38
 * @desc:力扣第295题（大/小堆）
 */
public class Problem295 {
    class MedianFinder {
        // 大顶堆：左半部分（数量 >= 右半部分）
        private final PriorityQueue<Integer> maxHeap;
        // 小顶堆：右半部分
        private final PriorityQueue<Integer> minHeap;

        public MedianFinder() {
            maxHeap = new PriorityQueue<>((a, b) -> b - a);
            minHeap = new PriorityQueue<>();
        }

        public void addNum(int num) {
            // 优先根据数值选择堆：小于等于左半段最大值 → 入大顶堆，否则入小顶堆
            if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }

            // 平衡1：大顶堆元素过多
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            }
            // 平衡2：小顶堆元素过多（原代码缺失这一步）
            else if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
        }

        public double findMedian() {
            // 总数奇数：大顶堆堆顶为中位数
            if (maxHeap.size() > minHeap.size()) {
                return maxHeap.peek();
            }
            // 总数偶数：两堆堆顶求平均
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }
}
