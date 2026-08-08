package LeetCode;

/**
 * @author: Yan Tong xue
 * @Created:2026/4/25 12:04
 * @desc:搜索旋转排序数组（二分查找）
 */
public class Problem33 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        // 必须循环！！！
        while (left <= right) {
            int mid = left + (right - left) / 2; // 每次循环都算新mid

            // 找到了
            if (nums[mid] == target) {
                return mid;
            }

            // 左半部分有序
            if (nums[left] <= nums[mid]) {//开头（nums[left]） > 中间值(nums[mid])，说明断裂藏在左半段，左边乱了、右边必然是完整有序的。
                // 目标在左区间
                if (nums[left] <= target && target < nums[mid]) {//目标在[nums[left], nums[mid})，只能去左边找
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // 右半部分有序
            else {
                // 目标在右区间
                if (nums[mid] < target && target <= nums[right]) {//目标在[nums[mid],nums[right]],只能去右边找
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1; // 循环结束都没找到
    }
}
