package LeetCode_Revice.zichuan;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/7 20:47
 * @desc:和为k的子数组
 * 核心逻辑（一句话记住）
 * 以每个位置为结尾，往左不断累加，遇到和为 k 就计数。
 */
public class p560 {
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
