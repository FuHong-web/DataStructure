package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Yan Tong xue
 * @Created:2026/3/17 22:52
 * @desc:力扣第15题：三数之和（贪心算法+双指针）
 */
public class Problem15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // 空数组或长度不足3，直接返回空结果
        if (nums == null || nums.length < 3) {
            return res;
        }
        // 排序：为了双指针和去重
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // 去重：跳过和前一个数相同的i（避免重复三元组）
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 左指针从i+1开始（核心修复点）
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    // 找到符合条件的三元组，添加到结果集
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    // 左指针去重：跳过相同的数
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // 右指针去重：跳过相同的数
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    // 双指针同时移动（核心修复点）
                    left++;
                    right--;
                } else if (sum < 0) {
                    // 和太小，左指针右移增大和
                    left++;
                } else {
                    // 和太大，右指针左移减小和
                    right--;
                }
            }
        }
        return res;
    }
}
