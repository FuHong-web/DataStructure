package LeetCode_Revice.dongtaiguihua;

import com.sun.tools.javac.Main;

import java.util.Arrays;

/**
 * @author: Yan Tong xue
 * @Created:2026/5/20 23:03
 * @desc:完全平方数
 */
public class p279 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE); // 先全部设为最大值
        dp[0] = 0;  // 基准：凑 0 需要 0 个平方数

        // 正确循环：从 1 一直算到 n
        for (int i = 1; i <= n; i++) {
            // 尝试所有 <= i 的平方数
            for (int j = 1; j * j <= i; j++) {
                // 核心递推公式
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }

}
