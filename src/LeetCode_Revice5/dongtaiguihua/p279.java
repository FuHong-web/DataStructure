package LeetCode_Revice5.dongtaiguihua;

import java.util.Arrays;

/*完全平方数*/
public class p279 {
    public int numSquares(int n){
        int[] dp = new int[n+1];
        Arrays.fill(dp,n+1);
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < i; j++) {
                int squre = j * j;
                dp[i] = Math.min(dp[i],dp[i-squre]+1);
            }
        }
        return dp[n];
    }
}
