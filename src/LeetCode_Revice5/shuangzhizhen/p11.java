package LeetCode_Revice5.shuangzhizhen;

import java.awt.event.MouseAdapter;

/*盛最多水得容器*/
public class p11 {
    public int maxArea(int[] nums){
        int maxArea = 0;
        int left = 0;
        int right = nums.length-1;
        while (left < right){
            maxArea = Math.max(maxArea,(right - left)*Math.min(nums[left],nums[right]));
            if(nums[left] < nums[right]){
                left++;
            }else {
                right--;
            }
        }
        return maxArea;
    }
}
