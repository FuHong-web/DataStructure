package LeetCode_Revice2.dongtaiguihua;

/**
 * @author: Yan Tong xue
 * @Created:2026/7/15 10:12
 * @desc:最长递增子序列
 */
public class p300 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        // dp数组全部初始化为1，对应vector<int> dp(nums.size(), 1)
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        int maxres = 1;
        // 外层循环i
        for (int i = 0; i < n; i++) {
            // 内层循环j < i
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    // 实时更新全局最大值
                    maxres = Math.max(maxres, dp[i]);
                }
            }
        }
        return maxres;
    }
}
