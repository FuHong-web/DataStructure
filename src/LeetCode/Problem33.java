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
            if (nums[left] <= nums[mid]) {
                // 目标在左区间
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // 右半部分有序
            else {
                // 目标在右区间
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1; // 循环结束都没找到
    }
}
