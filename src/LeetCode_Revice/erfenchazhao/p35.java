package LeetCode_Revice.erfenchazhao;

/**
 * @author: Yan Tong xue
 * @Created:2026/5/29 21:59
 * @desc:搜索插入位置
 */
public class p35 {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }else if (nums[mid] > target) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return nums[left] < target ? left + 1 : left;
        /*
        * 如果这个位置的数字 小于 target
→ target 必须放在它后面 → 返回 left + 1
如果这个位置的数字 大于等于 target
→ target 就放在这个位置 → 返回 left
        * */
    }
}
