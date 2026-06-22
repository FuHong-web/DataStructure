package Revice2.dongtaiguihua;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/20 18:12
 * @desc:打家劫舍
 */
public class p198 {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i-1],nums[i-1] + dp[i-2]);//偷第i间=当前间num[i-1](因为第i间对应的数组下表为i-1)+第前前的dp
        }
        return dp[n];
    }
}
