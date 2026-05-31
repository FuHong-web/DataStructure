package LeetCode;

import java.util.PriorityQueue;

/**
 * @author: Yan Tong xue
 * @Created:2026/5/5 21:38
 * @desc:力扣第295题（大/小堆）
 */
public class Problem295 {
    class MedianFinder{
        // 大顶堆：存放左半段
        private final PriorityQueue<Integer> maxHeap;
        // 小顶堆：存放右半段
        private final PriorityQueue<Integer> minHeap;
    public MedianFinder() {
        // 大顶堆 自定义比较器
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        // 默认小顶堆
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // 1. 优先加入大顶堆
        maxHeap.offer(num);

        // 2. 大顶堆最大值 > 小顶堆最小值，调整
        if (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
            minHeap.offer(maxHeap.poll());
        }

        // 3. 平衡数量：大顶堆最多比小顶堆多1个
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        }
    }
    public double findMedian() {
        // 奇数：大顶堆堆顶
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }
        // 偶数：两堆堆顶平均
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}
}
