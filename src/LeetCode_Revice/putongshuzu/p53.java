package LeetCode_Revice.putongshuzu;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/1 22:45
 * @desc:最大子数组和
 */
public class p53 {
    public int maxSubArray(int[] nums) {
        int maxSub = nums[0];
        int curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                curSum = 0;
            }
            curSum += nums[i];
            Math.max(curSum,maxSub);
        }
        return maxSub;
    }
}
