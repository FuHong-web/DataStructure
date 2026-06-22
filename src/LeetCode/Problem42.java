package LeetCode;

/**
 * @author: Yan Tong xue
 * @Created:2026/5/5 19:14
 * @desc:第42题：接雨水（双指针）单个位置能存的水 = min(左侧最高墙, 右侧最高墙) - 当前高度
 */
public class Problem42 {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxL = height[left];
        int maxR = height[right];
        int res = 0;
        while (left <= right) {
            maxL = Math.max(maxL,height[left]);
            maxR = Math.max(maxR,height[right]);
            if (maxL < maxR) {
                res += (maxL - height[left]);
                left++;
            }else {
                res += (maxR - height[right]);
                right--;
            }
        }
        return res;
    }
}
