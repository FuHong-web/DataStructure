package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/2 22:39
 * @desc:两数之和
 */
public class Problem1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                return new int[] {map.get(target-nums[i]),i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }


}
