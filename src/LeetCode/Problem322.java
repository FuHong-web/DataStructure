package LeetCode;

import java.util.Arrays;

/**
 * @author: Yan Tong xue
 * @Created:2026/4/1 23:52
 * @desc:力扣第32题：零钱兑换（）
 */
public class Problem322 {
    public int coinChange(int[] coins, int amount) {
        // 创建dp数组，大小为amount+1，初始值为amount+1（表示不可达）
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        // 遍历从1到amount的所有金额
        for (int i = 1; i <= amount; i++) {
            // 遍历每种硬币
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        // 如果dp[amount]仍然是初始值，说明无法组成该金额，返回-1
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
