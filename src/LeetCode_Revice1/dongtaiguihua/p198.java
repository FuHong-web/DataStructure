package LeetCode_Revice1.dongtaiguihua;

/**
 * @author: Yan Tong xue
 * @Created:2026/5/17 23:23
 * @desc:打家劫舍
 */
public class p198 {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];

        // 0间房
        if (n == 0) return 0;

        // 1间房
        dp[1] = nums[0];

        // 从第2间开始，一直算到第 n 间
        for (int i = 2; i <= n; i++) {
            // 核心：不偷 / 偷，选最大
            dp[i] = Math.max(dp[i-1], nums[i-1] + dp[i-2]);
        }

        return dp[n];
    }
}
