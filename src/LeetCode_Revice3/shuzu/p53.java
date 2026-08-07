package LeetCode_Revice3.shuzu;
/*最大子数组和*/
public class p53 {
    public int maxSubArray(int[] nums) {
        int cur = nums[0];
        int maxSum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            cur = Math.max(cur,nums[i]+cur);
            maxSum =Math.max(cur,maxSum);
        }
        return maxSum;
    }
}
