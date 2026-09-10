package LeetCode;

/**
 * @author: Yan Tong xue
 * @Created:2026/4/15 22:04
 * @desc:跳跃游戏II()
 */
public class Problem45 {
    public int jump(int[] nums) {
        int steps = 0;
        int currernEnd = 0;//当前这一跳能到达的右边界
        int maxReach = 0;//全局最远跳到的位置
        for (int i = 0;i < nums.length-1;i++){
            maxReach = Math.max(maxReach,i + nums[i]);

            //跳到i-1这一跳能到达的右边界,首先从i-1跳到i就要一次，然后更新i当前这一条可以到达的右边界
            if(i == currernEnd){
                steps++;
                currernEnd = maxReach;
            }
        }
        return steps;
    }
}
