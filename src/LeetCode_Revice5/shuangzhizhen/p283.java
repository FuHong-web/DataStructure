package LeetCode_Revice5.shuangzhizhen;

import java.awt.font.NumericShaper;

/*移动0*/
public class p283 {
    public void moveZeros(int[] nums){
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right]!= 0){
                nums[left] = nums[right];
                left++;
            }
        }
        while (left< nums.length){
            nums[left++] =0;
        }
    }
}
