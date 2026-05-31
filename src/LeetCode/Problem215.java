package LeetCode;

import java.util.Arrays;

/**
 * @author: Yan Tong xue
 * @Created:2026/3/9 23:18
 * @desc:力扣第215题：数组中的第 K 个最大元素
 */
public class Problem215 {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length;
        return nums[n-k];
    }
}
