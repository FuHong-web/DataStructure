package LeetCode_Revice4.dongtaiguihua;
/*最长连续递增子序列*/
public class p300 {
    public int lengthOfLIS(int[] nums){
        int maxRes = 1;
        int n = nums.length;
        int[] dp = new int[n+1];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                    maxRes = Math.max(dp[i],maxRes);
                }
            }
        }
        return maxRes;
    }
}
