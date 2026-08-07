package LeetCode_Revice3.zichuan;

import java.util.HashMap;
import java.util.Map;

public class p560 {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int preSum = 0;
        int count = 0;
        for(int num : nums) {
            preSum += num;
            if(map.containsKey(preSum-k)){
                count+=map.get(preSum-k);
            }
            map.put(preSum,map.getOrDefault(preSum,0)+1);
        }
        return count;
    }
}
