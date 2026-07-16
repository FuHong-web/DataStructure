package LeetCode_Revice2.dongtaiguihua;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/20 18:23
 * @desc:完全平方数
 * //1. dp[i - j*j] + 1 是什么？
 *                 //假设现在用平方数 j² 来凑 i：
 *                 //剩下需要凑的数：i - j²
 *                 //dp[i-j²] = 凑剩下部分最少需要几个平方数
 *                 //+1：代表额外加上当前这个平方数 j²
 */
public class p279 {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        for (int i = 1;i <= n;i++) {
            for (int j = 1;j * j <= i;j++) {
                dp[i] = Math.min(dp[i-1],dp[i-j*j] +1);
            }
        }
        return dp[n];
    }
}
