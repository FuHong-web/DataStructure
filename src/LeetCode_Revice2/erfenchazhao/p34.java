package LeetCode_Revice2.erfenchazhao;

/**
 * @author: Yan Tong xue
 * @Created:2026/7/8 22:45
 * @desc:
 */
public class p34 {
    public int[] searchRange(int[] nums, int target) {
        int left = fintIndex(nums,target,true);
        int right = fintIndex(nums,target,false);
        return new int[]{left,right};
    }
    public int fintIndex(int[] nums,int target,boolean isLeft) {
        int left = 0;
        int right = nums.length -1;
        int index = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            }else if (nums[mid] > target) {
                right--;
            }else {
                index = mid;
                if (isLeft) {
                    right = mid -1;
                }else {
                    left = mid+1;
                }
            }
        }
        return index;
    }
}
