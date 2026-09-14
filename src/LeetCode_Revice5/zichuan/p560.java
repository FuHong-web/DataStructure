package LeetCode_Revice5.zichuan;

import java.util.HashMap;
import java.util.Map;

/*和·为k的子数组*/
public class p560 {
    public int subarraySum(int[] nums, int k){
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int count = 1;
        int preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            if(map.containsKey(preSum - k)){
                count += map.get(preSum - k);
            }
            map.put(preSum,map.getOrDefault(preSum,0)+1);
        }
        return count;
    }
}
