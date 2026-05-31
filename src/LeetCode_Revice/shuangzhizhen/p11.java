package LeetCode_Revice.shuangzhizhen;

/**
 * @author: Yan Tong xue
 * @Created:2026/5/10 23:34
 * @desc:盛最多水的容器
 */
public class p11 {
    public int maxArea(int[] height) {
        int area = 0;
        int max_area = Integer.MIN_VALUE;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            area = (right - left) * Math.min(height[left],height[right]);
            max_area = Math.max(area,max_area);
            if (height[left] < height[right]) {
                left++;
            }else {
                right--;
            }
        }
        return max_area;
    }
}
