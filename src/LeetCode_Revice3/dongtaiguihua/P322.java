package LeetCode_Revice3.dongtaiguihua;

import java.util.Arrays;

/*兑换零钱*/
public class P322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for (int i = 1;i<=amount;i++) {
            for (int coin : coins) {
                if (i -coin>= 0) {
                    dp[i] = Math.max(dp[i],dp[i-coin] +1);
                }
            }
        }
        return dp[amount] > amount ? -1:dp[amount];
    }
}
