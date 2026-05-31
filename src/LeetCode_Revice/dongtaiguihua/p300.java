package LeetCode_Revice.dongtaiguihua;

/**
 * @author: Yan Tong xue
 * @Created:2026/5/20 23:56
 * @desc:最长递增子序列
 */
public class p300 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        // dp[i] 表示：以 nums[i] 结尾的最长递增子序列的长度
        int[] dp = new int[n];
        // 初始化：每个元素自身长度为1
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        // 外层循环：遍历每个元素 i
        for (int i = 1; i < n; i++) {
            // 内层循环：检查 i 之前的所有元素 j
            for (int j = 0; j < i; j++) {
                // 如果 nums[i] 比 nums[j] 大，说明可以接在后面形成更长的子序列
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        // 遍历 dp 数组，找到最大值（对应黑板最后一步）
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
