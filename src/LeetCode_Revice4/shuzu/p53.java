package LeetCode_Revice4.shuzu;

import javax.swing.*;

/*最大子数组和*/
public class p53 {
    public int maxSubArray(int[] nums){
    int maxSum = nums[0];
    int cur  = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cur = Math.max(nums[i],cur+nums[i]);
            maxSum  = Math.max(maxSum,cur);
        }
        return maxSum;
    }
}
