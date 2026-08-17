package LeetCode_Revice4.shuangzhizhen;
/*移动0*/
public class p183 {
    public void moveZeroes(int[] nums) {
        int left = 0;
        for(int right = 0;right< nums.length;right++){
            if(nums[right] != 0){
                nums[left++] = nums[right];
            }
        }
        while(left <nums.length){
            nums[left++] =0;
        }
    }
}
