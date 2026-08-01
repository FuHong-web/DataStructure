package LeetCode_Revice3.dongtaiguihua;

import java.util.Arrays;

/*完全平方数*/
/*
* dp[i] = min(旧的dp[i] , dp[i-item] + 1 )
item：当前选的物品（硬币 / 平方数）
dp [i-item]：凑剩余部分的最小数量
+1：加上当前选中的这一件物品
* */
public class p279 {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, n+1);
        dp[0] = 0;
        for (int i = 1;i<= n;i++) {
            for (int j = 1;j*j<= n;j++) {
                int square = j *j;
                dp[i] = Math.min(dp[i],dp[i-square]+1);}
        }
        return dp[n];
    }
}
