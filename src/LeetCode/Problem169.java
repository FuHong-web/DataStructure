package LeetCode;

import java.util.Arrays;

/**
 * @author: Yan Tong xue
 * @Created:2026/3/17 9:23
 * @desc:力扣第169题
 */
public class Problem169 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
