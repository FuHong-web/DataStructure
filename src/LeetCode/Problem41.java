package LeetCode;

/**
 * @author: Yan Tong xue
 * @Created:2026/4/25 10:59
 * @desc:缺失的第一个正整数（数组交换）
 */
public class Problem41 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // 把数字放到它应该在的位置：数字 x 应该在下标 x-1
            while (nums[i] >= 1 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                // 交换下标 i 和 nums[i]-1
                swap(nums, i, nums[i] - 1);
            }
        }

        // 遍历找第一个 下标i != 数字i+1 的位置
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // 都满足，返回 n+1
        return n + 1;
    }

    // 正确的交换：必须操作数组
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
