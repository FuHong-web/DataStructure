package LeetCode_Revice2.shuzu;

/**
 * @author: Yan Tong xue
 * @Created:2026/7/7 23:48
 * @desc:和最大的子数组和
 */
public class p53 {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int curSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 核心：选 「只取当前nums[i]」 OR 「前面的和 + nums[i]」
            curSum = Math.max(nums[i], curSum + nums[i]);
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }

}
