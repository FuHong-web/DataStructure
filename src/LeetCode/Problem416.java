package LeetCode;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author: Yan Tong xue
 * @Created:2026/4/19 21:51
 * @desc:力扣第416题：分割等和子集：动态规划
 */
public class Problem416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if(sum % 2 != 0) return false;
        int target = sum / 2;
        boolean[] dp = new boolean[target+1];
        dp[0] =true;
        for (int num : nums) {
            for(int i = target;i >= num;i--){
                if(dp[i -num]){
                    dp[i] = true;
                }
            }
            if(dp[target]){
                return true;
            }
        }
        return dp[target];
    }
}
