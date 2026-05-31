package LeetCode;

/**
 * @author: Yan Tong xue
 * @Created:2025/9/18 20:42
 * @desc:力扣第238题：移动0
 */
public class Problem283_1 {

    //方法一：类冒泡排序
    public void moveZeroes1(int[] nums) {
        int index=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=0){
                int temp=nums[i];
                nums[i]=nums[index];
                nums[index]=temp;
                index++;
            }
        }
    }
    //双指针
    public void moveZeroes2(int[] nums){
        int left=0;
        int right=0;
        while (right<nums.length){
            if (nums[right]!=0){
                swap(nums,left,right);
                left++;
            }
            right++;
        }
    }
    private void swap(int[] nums,int left,int right){
        int temp=nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
    }
}
