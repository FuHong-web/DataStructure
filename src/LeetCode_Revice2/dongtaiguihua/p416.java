package LeetCode_Revice2.dongtaiguihua;

import java.util.Arrays;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/21 11:18
 * @desc:分割等和子集
 */
public class p416 {

    public boolean canPartition(int[] nums) {
        int total_num = 0;
        for (int num : nums) {
            total_num += num;
        }
        // 总和奇数，不可能平分
        if (total_num % 2 != 0) return false;
        int target = total_num / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : nums) {
            boolean[] dpTemp = Arrays.copyOf(dp, dp.length);
            // 修正：遍历全部容量0 ~ target，不是nums长度
            for (int i = 0; i <= target; i++) {
                if (dp[i] && (i + num) <= target) {
                    dpTemp[i + num] = true;
                }
            }
            dp = dpTemp;
            if (dp[target]) return true;
        }
        return dp[target];
    }
}
