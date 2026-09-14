package LeetCode_Revice5.shuzu;
/*和最大的子数组*/
public class p53 {
    public int maxSub(int[] nums){
        int maxSum = nums[0];
        int curSum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            curSum = Math.max(nums[i],nums[i]+curSum);
            maxSum = Math.max(maxSum,curSum);
        }
        return maxSum;
    }
}
