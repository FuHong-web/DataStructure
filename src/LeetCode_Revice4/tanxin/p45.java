package LeetCode_Revice4.tanxin;
/*跳跃游戏ii*/
public class p45 {
    public int jump(int[] nums) {
        int maxReach =0;
        int curEnd = 0;
        int step = 0;
        for (int i = 0; i < nums.length-1; i++) {
            maxReach = Math.max(maxReach,i + nums[i]);
            if (i == curEnd){
                step++;
                curEnd = maxReach;
            }
        }
        return step;
    }
}
