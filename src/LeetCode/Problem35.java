package LeetCode;

/**
 * @author: Yan Tong xue
 * @Created:2026/1/25 14:08
 * @desc:力扣第35题：搜索插入位置
 */
public class Problem35 {
    public int searchInsert(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return nums[left] < target ? left + 1 : left;
    }
}
