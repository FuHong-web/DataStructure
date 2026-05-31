package LeetCode;

/**
 * @author: Yan Tong xue
 * @Created:2026/1/15 0:30
 * @desc:力扣第560题和为 K 的子数组
 */
public class Problem560 {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int right = 0; right < nums.length; ++right) {
            int sum = 0;
            for (int left = right; left >= 0; --left) {
                sum += nums[left];
                if (sum == k) count++;
            }
        }
        return count;
    }
}
