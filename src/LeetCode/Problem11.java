package LeetCode;

import java.util.WeakHashMap;

/**
 * @author: Yan Tong xue
 * @Created:2026/3/22 21:15
 * @desc:盛最多水的容器(双指针)
 * 每次移动较短的一侧，主动放弃 “以该短边为高度的所有更短 x 轴组合”，因为这些组合不可能更优。
 */
public class Problem11 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxArea = 0;
        while (left < right){
            maxArea = Math.max(maxArea,Math.min(height[left],height[right]) * (right-left+1));
            if(height[left] < height[right]){
                left++;
            }else {
                right--;
            }
        }
        return maxArea;
    }
}
