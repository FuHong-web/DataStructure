package LeetCode_Revice5.tanxin;
/*跳跃游戏*/
public class p55 {
    public boolean canJump(int[] nums){
        int maxReach = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if(i > maxReach){
                return false;
            }
            maxReach = Math.max(maxReach,i + nums[i]);
        }
        return true;
    }

}
