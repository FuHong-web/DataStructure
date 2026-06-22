package DifficultProblem;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/10 22:18
 * @desc:接雨水
 */
public class P42 {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxLeft = height[left];
        int maxRight = height[right];
        int res = 0;
        while (left < right) {
            maxLeft = Math.max(maxLeft,height[left]);
            maxRight = Math.max(maxRight,height[right]);
            if (maxLeft < maxRight) {
                res += maxLeft - height[left];
                left++;
            }else {
                res += maxRight - height[right];
                right--;
            }
        }
        return res;
    }
}
