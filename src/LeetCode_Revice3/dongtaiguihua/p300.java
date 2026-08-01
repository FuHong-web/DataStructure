package LeetCode_Revice3.dongtaiguihua;
/*最长递增子序列*/

import java.util.Arrays;

/*
* dp[i]：以 当前元素 nums[i] 结尾的最长递增子序列长度（正在计算中，还没确定）

dp[j]：以 前面的元素 nums[j] 结尾的最长递增子序列长度（已经算好了，是已知的）
* */
public class p300 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n =nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,1);
        int res = 1;
        for (int i =0;i<n;i++) {
            for(int j=0;j<i;j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i],dp[j]+1);
                    res = Math.max(res,dp[i]);
                }
            }
        }
        return res;

    }

}
