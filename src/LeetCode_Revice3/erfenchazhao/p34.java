package LeetCode_Revice3.erfenchazhao;
/*在排序数组中查找元素的第一个和最后一个位置*/
public class p34 {
    public int[] searchRange(int[] nums, int target) {
        int left = binary(nums,target,true);
        int right = binary(nums,target,false);
        return new int[]{left,right};
    }
    private int binary(int[] nums,int target,boolean isLeft){
        int left = 0;
        int right = nums.length-1;
        int index =-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            if (nums[mid] > target){
                right = mid -1;
            } else if (nums[mid] < target) {
                left = mid+1;
            }else {
                index  = mid;
                if(isLeft){
                    right = mid-1;
                }
                if (!isLeft){
                    left = mid+1;
                }
            }
        }
        return index;
    }
}
