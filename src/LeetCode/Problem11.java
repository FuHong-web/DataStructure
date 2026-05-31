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
        int left=0;
        int right=height.length-1;
        int max_area=Integer.MIN_VALUE;
        while (left<right){
            int area=(right-left)*Math.min(height[left],height[right]);
            max_area=Math.max(max_area,area);
            if (height[left]<height[right]){
                left++;
            }else {
                right--;
            }
        }
        return max_area;
    }
}
