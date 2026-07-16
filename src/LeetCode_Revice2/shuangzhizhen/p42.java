package LeetCode_Revice2.shuangzhizhen;

/**
 * @author: Yan Tong xue
 * @Created:2026/7/3 22:18
 * @desc:接雨水
 */
public class p42 {
    public int trap(int[] heigh) {
        int result = 0;
        int left = 0;
        int right = heigh.length-1;
        int maxLeft = heigh[left];
        int maxRight = heigh[right];
        while (left < right) {
            maxLeft = Math.max(maxLeft,heigh[left]);
            maxRight = Math.max(maxRight,heigh[right]);
            if (maxLeft < maxRight) {
                result += (maxLeft-heigh[left]);
                left++;
            }else {
                result += (maxRight - heigh[right]);
                right--;
            }
        }
return result;
    }
}
