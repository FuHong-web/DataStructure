package LeetCode;

/**
 * @author: Yan Tong xue
 * @Created:2026/5/8 22:58
 * @desc:下一个排列
 */
public class Problem31 {
    public void nextPermutation(int[] nums) {
        // 1. i 从倒数第二位开始向前遍历，目的比较 nums[i] 和 nums[i+1]，防止i+1越界
        int i = nums.length - 2;
        // 持续向前，找到第一个下标 i，满足 nums[i] < nums[i+1]
        // 循环结束后，[i+1, 末尾] 一定是降序序列
        while (i >= 0 && nums[i] >= nums[i+1]) {
            i--;
        }

        // i >= 0 代表找到了拐点，存在更大的排列
        if (i >= 0) {
            // j 从数组最后一位向前查找
            int j = nums.length - 1;
            // 在右侧降序区间，找到最靠右、且大于nums[i]的元素（大于nums[i]里最小的值）
            while (nums[j] <= nums[i]) {
                j--;
            }
            // 交换i、j位置的值，让i位置数字变大，整体排列变大
            swap(nums, i, j);
        }

        reverse(nums, i+1, nums.length-1);
    }
    private void reverse(int[] nums,int left,int right){
        while (left < right) {
            swap(nums,left,right);
            left++;
            right--;
        }
    }
    private void swap(int[] nums,int i,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
