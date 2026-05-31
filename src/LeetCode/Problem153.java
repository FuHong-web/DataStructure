package LeetCode;

/**
 * @author: Yan Tong xue
 * @Created:2026/5/30 23:56
 * @desc:寻找旋转数组的最小值
 */
public class Problem153 {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[left] <= nums[mid] && nums[mid] <= nums[right]) {
                return nums[left];
            } else if (nums[mid] >= nums[left]) {
                left = mid + 1;
            } else if (nums[mid] <= nums[right]) {
                right = mid;
            }
        }
        return -1;
    }
}
