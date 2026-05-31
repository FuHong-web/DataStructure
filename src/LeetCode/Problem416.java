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
        int total_sum = 0;
        for (int num : nums) {
            total_sum += num;
        }

        // 和为奇数，不可能平分
        if (total_sum % 2 != 0) return false;

        int target = total_sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;  // 基础状态：和为0一定可以

        for (int num : nums) {
            // 1. 先备份上一轮的dp（不能直接覆盖）
            boolean[] dpTemp = Arrays.copyOf(dp, dp.length);

            // 2. 用旧dp 更新 新dpTemp
            for (int i = 0; i <= target; i++) {
                if (dp[i] && i + num <= target) {
                    dpTemp[i + num] = true;  // 这里改 dpTemp！
                }
            }

            // 3. 更新dp为最新状态
            dp = dpTemp;

            // 提前找到答案
            if (dp[target]) return true;
        }

        return dp[target];
    }
}
