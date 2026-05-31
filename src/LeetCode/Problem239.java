package LeetCode;

import java.util.Arrays;

/**
 * @author: Yan Tong xue
 * @Created:2026/4/25 0:14
 * @desc:滑动窗口（双指针）
 */
public class Problem239 {
    public static int[] minSubArrayLen(int target, int[] nums) {
        int i = 0;                  // 窗口左边界
        int sum = 0;                // 窗口和
        int minLen = Integer.MAX_VALUE; // 记录最小长度
        int start = 0;              // 记录最终子数组的起始位置
        int end = 0;                // 记录最终子数组的结束位置

        // 右指针j遍历数组，扩张窗口
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];

            // 当窗口和满足条件时，尝试收缩左边界
            while (sum >= target) {
                int currentLen = j - i + 1;
                // 如果当前窗口长度更小，更新最小长度和起止下标
                if (currentLen < minLen) {
                    minLen = currentLen;
                    start = i;
                    end = j;
                }
                // 左边界右移，缩小窗口
                sum -= nums[i];
                i++;
            }
        }

        // 如果没有找到满足条件的子数组，返回空数组
        if (minLen == Integer.MAX_VALUE) {
            return new int[0];
        }

        // 截取子数组并返回
        return Arrays.copyOfRange(nums, start, end + 1);
    }
}
