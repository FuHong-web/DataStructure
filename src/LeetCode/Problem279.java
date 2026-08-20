package LeetCode;

import java.util.*;

/*dp[i - square] 是凑出 i-square 需要多少个数；
现在额外加上 square 这1 个完全平方数，才能拼成 i，所以 +1。*/
/**
 * @author: Yan Tong xue
 * @Created:2026/3/25 23:57
 * @desc:力扣第279：完全平方数（动态规划）
 */
public class Problem279 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 1);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                int square = j * j;
                dp[i] = Math.min(dp[i], dp[i - square] + 1);
            }
        }
        return dp[n];
    }


}
