package LeetCode_Revice3.dui;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*前k个高频元素*/
public class p347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num :nums) {
            map.put(num,map.getOrDefault(num,0) +1);
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) ->a[1]-a[1]);
        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int fre = entry.getValue();
            minHeap.add(new int[] {num,fre});
            if (minHeap.size()>k) {
                minHeap.poll();
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = minHeap.poll()[0];
        }
        return res;
    }
}
