package LeetCode_Revice.shuangzhizhen;

/**
 * @author: Yan Tong xue
 * @Created:2026/5/29 22:45
 * @desc:力扣第34题：在排序数组中查找元素的第一个和最后一个位置(二分查找)
 */
public class p34 {
    public int[] searchRange(int[] nums, int target)  {
        int left = binBiary(nums,target,true);
        int right = binBiary(nums,target,false);
        return new int[]{left,right};
    }
    public int binBiary(int[] nums,int target,boolean isleft) {
        int left = 0;
        int right = nums.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid -1;
            }else if (nums[mid] < target) {
                left = mid + 1;
            }else {
                index = mid;
                if (isleft) {
                    right = mid -1;
                }else {
                    left = mid + 1;
                }
            }
        }
        return index;
    }
}
