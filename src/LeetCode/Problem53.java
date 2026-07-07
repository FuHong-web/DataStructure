package LeetCode;

/**
 * @author: Yan Tong xue
 * @Created:2026/1/18 23:36
 * @desc:力扣第53题：最大子数组和
 *
 * 如果前面的和是负数，那就扔掉前面所有，重新开始！
 * 因为负数只会拖后腿，加上它只会让总和变小。
 */
public class Problem53 {
    public int maxSubArray(int[] nums){
        int maxSub=nums[0];
        int curSum=0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]<0){
                curSum=0;
            }
            curSum+=nums[i];
            maxSub=Math.max(curSum,maxSub);
        }
        return maxSub;
    }
}
