package Revice2.shuangzhizhen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Yan Tong xue
 * @Created:2026/7/3 23:34
 * @desc:三数之和
 */
public class p15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        if (nums.length < 3) return res;
        for (int i = 0; i < nums.length; i++) {
            // 固定第一个数i，跳过重复，避免重复三元组
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    // 先收缩指针
                    left++;
                    right--;
                    // 跳过左侧重复：当前left和刚刚用过的left-1相同
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    // 跳过右侧重复：当前right和刚刚用过的right+1相同
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (sum < 0) {
                    // 和太小，左指针右移增大总和
                    left++;
                } else {
                    // 和太大，右指针左移减小总和
                    right--;
                }
            }
        }
        return res;
    }
}
