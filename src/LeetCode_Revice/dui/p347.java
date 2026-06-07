package LeetCode_Revice.dui;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/2 23:14
 * @desc:前k个高频元素
 *
 * 用 HashMap 统计每个数字出现次数
 * 用 小顶堆 只保留前 k 个频率最高的
 * 堆里只留 k 个
 * 多了就把频率最小的扔出去
 * 最后把堆里的数字拿出来就是答案
 */
public class p347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freMap = new HashMap<>();
        for (int num : nums) {
            freMap.put(num,freMap.getOrDefault(num,0) + 1);
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (Map.Entry<Integer,Integer> entry : freMap.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();
            minHeap.offer(new int[]{num,freq});
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        int[] res = new int[k];
        for (int i = 0;i<k;i++) {
            res[i] = minHeap.poll()[0];
        }
        return res;
    }

}
