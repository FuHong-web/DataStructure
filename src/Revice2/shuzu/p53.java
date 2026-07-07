package Revice2.shuzu;

/**
 * @author: Yan Tong xue
 * @Created:2026/7/7 23:48
 * @desc:和最大的子数组和
 */
public class p53 {
    public int maxSubArray(int[] nums) {
        int maxSub = nums[0];
        int curSub = 0;
        for (int i = 0;i < nums.length;i++) {
            if (nums[i] < 0) {
                curSub = 0;
            }
            curSub += nums[i];
            maxSub = Math.max(curSub,maxSub);
        }
        return maxSub;
    }
}
