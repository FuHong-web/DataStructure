package LeetCode_Revice3.shuangzhizhen;
/*移动0*/
public class p283 {
    public void moveZeroes1(int[] nums) {
        int left= 0;
        for(int right = 0;right<nums.length;right++) {
            if(nums[right] != 0) {
                nums[left++] = nums[right];
            }
        }
        while (left<nums.length){
            nums[left++] = 0;
        }
    }
}
