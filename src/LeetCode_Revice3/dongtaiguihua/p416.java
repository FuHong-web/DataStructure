package LeetCode_Revice3.dongtaiguihua;

import java.util.Arrays;

/*分割等和子集*/
public class p416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num: nums) sum+= num;
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        boolean[] dp = new boolean[target+1];
        dp[0] =true;
        for(int num : nums) {
            boolean[] dpTemp =Arrays.copyOf(dp,dp.length);
            for (int i =0;i<=target;i++) {
                if (dp[i] && i+nums[i] <=target) {
                    dpTemp[i] = true;
                }
            }
            dp = dpTemp;
        }
        return dp[target];
    }
}
