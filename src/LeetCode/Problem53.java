package LeetCode;

/**
 * @author: Yan Tong xue
 * @Created:2026/1/18 23:36
 * @desc:力扣第53题：最大子数组和
 */
public class Problem53 {
    public int maxSubArray(int[] nums){
        int maxSub=nums[0];
        int curSum=0;
        for (int i=0;i<nums.length;i++){
            if (curSum<0){
                curSum=0;
            }
            curSum+=nums[i];
            maxSub=Math.max(curSum,maxSub);
        }
        return maxSub;
    }
}
