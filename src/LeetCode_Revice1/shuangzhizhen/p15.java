package LeetCode_Revice1.shuangzhizhen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Yan Tong xue
 * @Created:2026/5/10 23:54
 * @desc:三数之和
 */
public class p15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;   // ✅ 只在找到解后移动
                    right--;
                } else if (sum < 0) {
                    left++;   // ✅ sum太小，左指针右移
                } else {
                    right--;  // ✅ sum太大，右指针左移（注意是right--）
                }
                // ❌ 删掉这里的 left++ 和 right--
            }
        }
        return result;
    }
}
