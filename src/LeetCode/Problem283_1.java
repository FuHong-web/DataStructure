package LeetCode;

/**
 * @author: Yan Tong xue
 * @Created:2025/9/18 20:42
 * @desc:力扣第238题：移动0
 */
public class Problem283_1 {


    public void moveZeroes1(int[] nums) {
        int left = 0;
        for(int right = 0;right<nums.length;right++){
            if(nums[right] != 0){
                nums[left++] = nums[right];
            }
        }
        while (left<nums.length) {
            nums[left++] = 0;
        }
    }
}
