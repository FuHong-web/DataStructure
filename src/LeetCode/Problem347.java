package LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author: Yan Tong xue
 * @Created:2026/4/11 13:24
 * @desc:力扣第347题：前k个频率最高的元素（最小堆）
 */
public class Problem347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freMap = new HashMap<>();
        for (int num : nums) {
            freMap.put(num,freMap.getOrDefault(num,0) + 1);
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[1] - b[1]);
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
