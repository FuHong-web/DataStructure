package LeetCode_Revice1.zichuan;

import java.util.HashMap;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/7 20:47
 * @desc:和为k的子数组
 * 核心逻辑（一句话记住）
 * 以每个位置为结尾，往左不断累加，遇到和为 k 就计数。
 */
public class p560 {
    public int subarraySum(int[] nums, int k) {
        // key：前缀和数值，value：该前缀和出现的次数
        HashMap<Integer, Integer> preSumMap = new HashMap<>();
        // 初始化：前缀和0 出现1次，对应从数组开头到当前位置刚好等于k的情况
        preSumMap.put(0, 1);

        int count = 0;    // 符合条件子数组总数
        int preSum = 0;   // 实时累加的前缀和

        for (int num : nums) {
            preSum += num; // 更新当前前缀和

            // 我们需要找 前缀和 = preSum - k 的历史次数
            int target = preSum - k;
            if (preSumMap.containsKey(target)) {
                // 存在多少个target，就新增多少个合法子数组
                count += preSumMap.get(target);
            }

            // 把当前前缀和存入哈希表，次数+1
            preSumMap.put(preSum, preSumMap.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }

}
