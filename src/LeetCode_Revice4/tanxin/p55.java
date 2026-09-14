package LeetCode_Revice4.tanxin;
/*跳跃游戏*/
public class p55 {
    public boolean canJump(int[] nums){
        int maxReach = 0;
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if(i > maxReach){// 判断①：当前位置 i 能不能到达
                return false;
            }
            maxReach = Math.max(maxReach,i+nums[i]);
            if(maxReach > n- 1){ // 判断②：最远能不能覆盖终点？
                return true;
            }
        }
        return true;
    }
}
