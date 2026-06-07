package LeetCode_Revice.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/2 22:41
 * @desc:两数之和
 */
public class p1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            // 看看我需要的数字，之前有没有存过
            if (map.containsKey(target - nums[i])) {
                // 找到了！返回 【之前的下标，当前下标】
                return new int[] {map.get(target - nums[i]), i};
            }
            // 没找到，把当前数字和下标存起来
            map.put(nums[i], i);
        }

        // 题目保证有解，这里必须返回一个数组
        return new int[0];
    }
}
