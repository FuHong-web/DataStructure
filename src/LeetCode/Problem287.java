package LeetCode;
/*
* 不是对数组索引二分，而是对数字的值范围二分

统计数组中小于等于某个值的元素个数

如果个数超过这个值，说明重复数字一定在这个范围内
*
* 数范围二分，统计来判断，多了往左找，少了往右跑"
* */
/**
 * @author: Yan Tong xue
 * @Created:2026/4/29 23:11
 * @desc:寻找重复数（快慢指针）
 */
public class Problem287 {
    public int findDuplicate(int[] nums) {
        // 数字范围 1 ~ n
        int left = 1, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = 0;
            // 统计数组里 <= mid 的数字有多少个
            for (int num : nums) {
                if (num <= mid) count++;
            }
            // 数量大于mid，说明重复数字落在 [left,mid]
            if (count > mid) {
                right = mid;
            } else {
                // 否则落在 [mid+1,right]
                left = mid + 1;
            }
        }
        return left;
    }
}
