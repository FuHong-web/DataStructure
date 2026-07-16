package LeetCode_Revice2.jiqiao;

import java.util.Arrays;

/**
 * @author: Yan Tong xue
 * @Created:2026/7/14 23:19
 * @desc:寻找重复数
 */
public class p287 {
    public int findDuplicate(int[] nums) {
        // 先排序
        Arrays.sort(nums);
        // 从第二个数开始遍历，和前一个对比
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }
        // 题目保证一定有重复，不会走到这里
        return -1;
    }
}
