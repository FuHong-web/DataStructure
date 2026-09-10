package LeetCode;

/**
 * @author: Yan Tong xue
 * @Created:2026/4/12 23:34
 * @desc:力扣第300题;最长递增子序列（动态规划）
 */
public class Problem300 {
    public int lengthOfLIS(int[] nums) {
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
