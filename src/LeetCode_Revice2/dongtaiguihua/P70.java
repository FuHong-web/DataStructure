package LeetCode_Revice2.dongtaiguihua;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/20 17:46
 * @desc:爬楼梯
 */
public class P70 {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2;i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
