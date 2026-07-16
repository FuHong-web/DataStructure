package LeetCode_Revice1.erfenchazhao;

/**
 * @author: Yan Tong xue
 * @Created:2026/5/29 21:59
 * @desc:搜索插入位置
 */
public class p35 {

        public int searchInsert(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;

            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] == target) {
                    // 找到目标，直接返回下标
                    return mid;
                } else if (nums[mid] > target) {
                    // 中间值更大，目标在左区间，缩小右边界
                    right = mid - 1;
                } else {
                    // 中间值更小，目标在右区间，扩大左边界
                    left = mid + 1;
                }
            }
            // 循环结束 left > right，left就是插入位置
            return left;
        }
    }

