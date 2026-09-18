package LeetCode_Revice5.dongtaiguihua;

import java.util.Arrays;

/*最长递增子序列*/
public class p300 {
    public int lengthOfLIS(int[] nums){
        int n = nums.length;
        int[] dp = new int[n+1];
        int maxRes = 1;
        Arrays.fill(dp,1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[i]+1);
                }
            }
            maxRes = Math.max(maxRes,dp[i]);
        }
        return maxRes;
    }
}
