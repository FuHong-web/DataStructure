package LeetCode;

/**
 * @author: Yan Tong xue
 * @Created:2026/3/27 23:48
 * @desc:寻找旋转排序数组中的最小值(双段双指针)
 */
public class Problem253 {
    public int findMin(int[] nums){
        int low=0;
        int high=nums.length-1;
        while (low<high){
            int mid=low+(high-low)/2;
            if (nums[mid]<nums[high]){
                high=mid;
            }else {
                low=mid+1;
            }
        }
        return nums[low];
}}
