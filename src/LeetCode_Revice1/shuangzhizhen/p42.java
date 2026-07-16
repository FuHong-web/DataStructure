package LeetCode_Revice1.shuangzhizhen;

/**
 * @author: Yan Tong xue
 * @Created:2026/5/11 22:47
 * @desc:接雨水
 */
public class p42 {
    public int trap(int[] height) {
        int result = 0;
        int left = 0;
        int right = height.length - 1;
        int maxL = height[left];
        int maxR = height[right];
        while (left < right) {
           maxL = Math.max(maxL,height[left]);
           maxR = Math.max(maxR,height[right]);
           if (maxL < maxR) {
               result += (maxL - height[left]);
               left++;
           }else {
               result += (maxR - height[right]);
               right--;
           }
        }

        return result;
    }
}

